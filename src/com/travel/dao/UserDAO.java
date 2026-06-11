package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.travel.model.User;

public class UserDAO {
    public User loginUser(String username, String password) {
        Connection conn = null;
        User user = null;
        try {
            conn = DBConnection.getConnection();
            String sql =
                    "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("full_name"));
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn);
        }
        return user;
    }
    public boolean registerUser(User user) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql =
                    "INSERT INTO users(username,password,email,full_name,phone,address,role) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getFullName());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getAddress());
            pstmt.setString(7, "customer");
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.closeConnection(conn);
        }
    }
}