package Service;

import java.sql.*;

public class CustomerDao {

    public void insertCustomer(String name, String phone, String email, String address){

        String sql = "INSERT INTO customer(name, phone, email, address) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,phone);
            ps.setString(3,email);
            ps.setString(4,address);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getAllCustomer(){

        String sql = "SELECT * FROM customer";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.printf("%-5s %-20s %-15s %-25s %-20s\n",
                    "ID","NAME","PHONE","EMAIL","ADDRESS");

            while(rs.next()){

                System.out.printf("%-5d %-20s %-15s %-25s %-20s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkCustomer(int id){

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

    public void updateCustomer(int id,String name,String phone,String email,String address){

        String sql = "UPDATE customer SET name=?, phone=?, email=?, address=? WHERE id=?";

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,phone);
            ps.setString(3,email);
            ps.setString(4,address);
            ps.setInt(5,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

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