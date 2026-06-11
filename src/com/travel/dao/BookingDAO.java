package com.travel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.travel.model.Booking;

public class BookingDAO {
    public boolean createBooking(Booking booking) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql =
                    "INSERT INTO bookings(user_id,package_id,travel_date,num_people,total_price,status) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getPackageId());
            pstmt.setDate(
                    3,
                    Date.valueOf(
                            booking.getTravelDate()));
            pstmt.setInt(
                    4,
                    booking.getNumPeople());
            pstmt.setBigDecimal(
                    5,
                    booking.getTotalPrice());
            pstmt.setString(
                    6,
                    "pending");
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.closeConnection(conn);
        }
    }
}