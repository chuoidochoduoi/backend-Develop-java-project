package dao.impl;

import Model.InvoiceDetail;
import dao.IInvoiceDetailDao;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static utils.TablePrinter.printInvoiceDetailTable;

public class InvoiceDetailDao implements IInvoiceDetailDao {

    public void insertInvoiceDetail(InvoiceDetail detail){

        String sql = """
                INSERT INTO invoice_details(invoice_id, product_id, quantity, unit_price)
                VALUES (?, ?, ?, ?)
                """;

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, detail.getInvoiceId());
            ps.setInt(2, detail.getProductId());
            ps.setInt(3, detail.getQuantity());
            ps.setDouble(4, detail.getPrice());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getAllInvoiceByInvoiceID(int invoiceId) {

        String sql = """
            SELECT id, invoice_id, product_id, quantity, unit_price
            FROM invoice_details
            WHERE invoice_id = ?
            """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, invoiceId);

            ResultSet rs = ps.executeQuery();

            printInvoiceDetailTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
