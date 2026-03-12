package dao.impl;

import dao.IProductDAO;
import utils.DBConnection;

import java.sql.*;

public class ProductDao implements IProductDAO {
    @Override

    public void insertProduct(String name, String brand, double price, int stock) {
        String sql = "INSERT INTO product(name, brand, price, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setInt(4, stock);

            ps.executeUpdate();



        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void getAllProduct(){


        String sql = "SELECT * FROM product ";
        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.printf("%-5s %-20s %-15s %-10s %-10s\n",
                    "ID", "NAME", "BRAND", "PRICE", "STOCK");

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-15s %-10.2f %-10d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("stock"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public boolean checkProduct(int id){


        String sql = "SELECT * FROM product WHERE id=?";
        try (Connection conn = DBConnection.getConnection()){

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return true;
            };
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public void updateProduct(int id,String name, String brand, double price, int stock) {
        String sql = "UPDATE product SET name=?, brand=?, price=?, stock=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setInt(4, stock);

            ps.setInt(5, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id){


        String sql = "delete FROM product WHERE id=?";
        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public void getProductByPrice(double priceStart, double priceEnd){


        String sql = "select * FROM product WHERE price between ? and ?";
        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, priceStart);
            ps.setDouble(2, priceEnd);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            System.out.printf("%-5s %-20s %-15s %-10s %-10s\n",
                    "ID", "NAME", "BRAND", "PRICE", "STOCK");

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-15s %-10.2f %-10d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("stock"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public void getProductByBrand(String brand){


        String sql = "select * FROM product WHERE brand ilike ?";
        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, brand);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            System.out.printf("%-5s %-20s %-15s %-10s %-10s\n",
                    "ID", "NAME", "BRAND", "PRICE", "STOCK");

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-15s %-10.2f %-10d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("stock"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public void getProductByName(String name){


        String sql = "select * FROM product WHERE name ilike ?";
        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            System.out.printf("%-5s %-20s %-15s %-10s %-10s\n",
                    "ID", "NAME", "BRAND", "PRICE", "STOCK");

            while (rs.next()) {

                int stock = rs.getInt("stock");
                 String stockAvailability ;
                if (stock > 0) {
                    stockAvailability = "AVAILABLE";
                }else {
                    stockAvailability = "UNAVAILABLE";
                }
                System.out.printf("%-5d %-20s %-15s %-10.2f %-10d %-5s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        stock,
                        stockAvailability);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
