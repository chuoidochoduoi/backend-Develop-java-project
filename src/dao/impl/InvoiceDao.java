package dao.impl;

import dao.IInvoiceDAO;
import utils.DBConnection;

import java.sql.*;

public class InvoiceDao implements IInvoiceDAO {
    @Override

    public void insertInvoice(int customerId, double totalAmount) {

        String sql = "INSERT INTO invoice(customer_id, total_amount) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setDouble(2, totalAmount);

            ps.executeUpdate();

            System.out.println("Tạo hóa đơn thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
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

            System.out.printf("%-5s %-20s %-25s %-10s\n",
                    "ID", "Customer", "Date", "Total");

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-25s %-10.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at"),
                        rs.getDouble("total_amount")
                );
            }

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

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-25s %-10.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at"),
                        rs.getDouble("total_amount")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void searchByDate(String date) {

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

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-25s %-10.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at"),
                        rs.getDouble("total_amount")
                );
            }

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

            while (rs.next()) {

                System.out.println(
                        rs.getDate("day") +
                                " : " +
                                rs.getDouble("revenue")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void revenueByMonth() {

        String sql = """
                SELECT DATE_TRUNC('month', created_at) as month,
                SUM(total_amount) as revenue
                FROM invoice
                GROUP BY month
                ORDER BY month
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("Doanh thu theo tháng");

            while (rs.next()) {

                System.out.println(
                        rs.getTimestamp("month") +
                                " : " +
                                rs.getDouble("revenue")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void revenueByYear() {

        String sql = """
                SELECT DATE_TRUNC('year', created_at) as year,
                SUM(total_amount) as revenue
                FROM invoice
                GROUP BY year
                ORDER BY year
                """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("Doanh thu theo năm");

            while (rs.next()) {

                System.out.println(
                        rs.getTimestamp("year") +
                                " : " +
                                rs.getDouble("revenue")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}