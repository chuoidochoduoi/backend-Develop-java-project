package dao.impl;

import Model.Phone;
import dao.IProductDAO;
import utils.DBConnection;

import java.sql.*;

import static utils.TablePrinter.printProductTable;

public class ProductDao implements IProductDAO {
    @Override

    public void insertProduct(Phone phone) {
        String sql = "INSERT INTO product(name, brand, price, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone.getName());
            ps.setString(2, phone.getBrand());
            ps.setDouble(3, phone.getPrice());
            ps.setInt(4, phone.getStock());
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

            printProductTable(rs);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public boolean existsProductById(int id){


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

    public void updateProduct(Phone phone) {
        String sql = "UPDATE product SET name=?, brand=?, price=?, stock=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone.getName());
            ps.setString(2, phone.getBrand());
            ps.setDouble(3, phone.getPrice());
            ps.setInt(4, phone.getStock());

            ps.setInt(5, phone.getId());
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

            printProductTable(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public void getProductByBrand(String brand){


        String sql = "SELECT * FROM product WHERE brand ILIKE ?";


        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + brand + "%");
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            printProductTable(rs);

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
            ps.setString(1, "%" + name + "%");
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            printProductTable(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public Phone getProductById(int id){


        String sql = "select * FROM product WHERE id = ?";
        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Phone phone = new Phone();
                    phone.setId(rs.getInt("id"));
                    phone.setName(rs.getString("name"));
                    phone.setPrice(rs.getDouble("price"));

                    return phone;
                }
        return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateProductQuantity(int productId, int stock) {

        String sql = """
            UPDATE product
            SET stock = stock - ?
            WHERE id = ?
             AND stock >= ?
            """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, stock);
            ps.setInt(2, productId);
            ps.setInt(3, stock);

            int rows = ps.executeUpdate();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
