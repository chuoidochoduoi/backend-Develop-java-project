package dao.impl;

import Model.InvoiceDetail;
import dao.IInvoiceDetailDao;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static utils.TablePrinter.printInvoiceDetailTable;

public class InvoiceDetailDao implements IInvoiceDetailDao {

    public void     insertInvoiceDetail(InvoiceDetail detail){

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

    @Override
    public void deleteInvoiceDetailByInvoiceId(int id){

        String sql = " delete from invoice_details where invoice_id in (select id FROM invoice WHERE customer_id=?)";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteInvoiceDetailByProductId(int id){

        String deleteDetail = "DELETE FROM invoice_details WHERE product_id=?";
        String deleteInvoice = "DELETE FROM invoice WHERE id IN (SELECT invoice_id FROM invoice_details WHERE product_id=?)";

        try(Connection conn = DBConnection.getConnection()){

            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(deleteDetail);
            ps1.setInt(1, id);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(deleteInvoice);
            ps2.setInt(1, id);
            ps2.executeUpdate();

            conn.commit();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isProductInInvoice(int productId){

        String sql = "SELECT 1 FROM invoice_details WHERE product_id=? LIMIT 1";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
