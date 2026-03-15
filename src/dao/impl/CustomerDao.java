package dao.impl;

import Model.Customer;
import dao.ICustomerDAO;
import dao.IProductDAO;
import utils.DBConnection;

import java.sql.*;

import static utils.TablePrinter.printCustomerTable;

public class CustomerDao implements ICustomerDAO {

   @Override
    public void insertCustomer(Customer customer){

        String sql = "INSERT INTO customer(name, phone, email, address) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,customer.getName());
            ps.setString(2,customer.getPhone());
            ps.setString(3,customer.getEmail());
            ps.setString(4,customer.getAddress());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override

    public void getAllCustomer(){

        String sql = "SELECT * FROM customer";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            printCustomerTable(rs);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean existsCustomerById(int id){

        String sql = "SELECT * FROM customer WHERE id=?";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
    @Override

    public void updateCustomer(Customer customer){

        String sql = "UPDATE customer SET name=?, phone=?, email=?, address=? WHERE id=?";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,customer.getName());
            ps.setString(2,customer.getPhone());
            ps.setString(3,customer.getEmail());
            ps.setString(4,customer.getAddress());
            ps.setInt(5,customer.getId());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override

    public void deleteCustomer(int id){

        String sql = "DELETE FROM customer WHERE id=?";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}