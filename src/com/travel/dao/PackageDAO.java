package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.travel.model.Package;

public class PackageDAO {
    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM packages";
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Package pkg = new Package();
                pkg.setPackageId(rs.getInt("package_id"));
                pkg.setPackageName(rs.getString("package_name"));
                pkg.setDestination(rs.getString("destination"));
                pkg.setDurationDays(rs.getInt("duration_days"));
                pkg.setDescription(rs.getString("description"));
                pkg.setPrice(rs.getBigDecimal("price"));
                pkg.setImageUrl(rs.getString("image_url"));
                packages.add(pkg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn);
        }
        return packages;
    }
}