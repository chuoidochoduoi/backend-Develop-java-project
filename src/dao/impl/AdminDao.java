package dao.impl;

import dao.IAdminDao;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao implements IAdminDao {

    public boolean login(String username,String password){

        String sql = """
                SELECT * 
                FROM admin
                WHERE username = ? AND password = ?
                """;

        try(Connection conn = DBConnection.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
}