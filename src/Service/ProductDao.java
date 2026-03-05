package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDao {

    public void insertProduct(String name, String brand, double price, int stock) {
        String sql = "INSERT INTO product(name, brand, price, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setInt(4, stock);

            ps.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
