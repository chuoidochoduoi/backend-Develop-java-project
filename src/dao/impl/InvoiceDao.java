package dao.impl;

import Model.Invoice;
import dao.IInvoiceDAO;
import utils.DBConnection;

import java.sql.*;
import java.time.LocalDate;

import static utils.TablePrinter.printInvoiceTable;
import static utils.TablePrinter.printRevenumTable;

public class InvoiceDao implements IInvoiceDAO {
    @Override

    public void insertInvoice(Invoice invoice) {

        String sql = "INSERT INTO invoice(customer_id, total_amount) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, invoice.getCustomerId());
            ps.setDouble(2, invoice.getTotal());

            ps.executeUpdate();

            System.out.println("Tạo hóa đơn thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean existsInvoiceById(int id) {

        String sql = "SELECT 1 FROM invoice WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override

    public void getAllInvoice() {

        String sql = """
                SELECT i.id, c.name, i.created_at, i.total_amount
                FROM invoice i
                JOIN customer c ON i.customer_id = c.id
                ORDER BY i.id
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            printInvoiceTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void searchByCustomerName(String keyword) {

        String sql = """
                SELECT i.id, c.name, i.created_at, i.total_amount
                FROM invoice i
                JOIN customer c ON i.customer_id = c.id
                WHERE c.name ILIKE ?
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            printInvoiceTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void searchByDate(LocalDate date) {

        String sql = """
                SELECT i.id, c.name, i.created_at, i.total_amount
                FROM invoice i
                JOIN customer c ON i.customer_id = c.id
                WHERE DATE(i.created_at) = ?
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(date));

            ResultSet rs = ps.executeQuery();

            printInvoiceTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void revenueByDay() {

        String sql = """
                SELECT DATE(created_at) as day, SUM(total_amount) as revenue
                FROM invoice
                GROUP BY day
                ORDER BY day
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("Doanh thu theo ngày");

            printRevenumTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void revenueByMonth() {

        String sql = """
                SELECT TO_CHAR(created_at, 'YYYY-MM') as month,
                SUM(total_amount) as revenue
                FROM invoice
                GROUP BY month
                ORDER BY month
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("Doanh thu theo tháng");

            printRevenumTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void revenueByYear() {

        String sql = """
                SELECT TO_CHAR(created_at, 'YYYY') as year,
                SUM(total_amount) as revenue
                FROM invoice
                GROUP BY year
                ORDER BY year
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("Doanh thu theo năm");

            printRevenumTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLastInvoiceId() {

        String sql = """
            SELECT id
            FROM invoice
            ORDER BY id DESC
            LIMIT 1
            """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

}