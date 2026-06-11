package com.travel.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.travel.dao.BookingDAO;
import com.travel.model.Booking;
import com.travel.model.User;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User)session.getAttribute("user");

        if(user == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        Booking booking = new Booking();

        booking.setUserId(
                user.getUserId());

        booking.setPackageId(
                Integer.parseInt(
                        request.getParameter("packageId")));

        booking.setTravelDate(
                request.getParameter("travelDate"));

        booking.setNumPeople(
                Integer.parseInt(
                        request.getParameter("numPeople")));

        booking.setTotalPrice(
                new BigDecimal(
                        request.getParameter("totalPrice")));

        BookingDAO dao =
                new BookingDAO();

        boolean success =
                dao.createBooking(booking);

        if(success) {

            response.sendRedirect(
                    "booking_success.jsp");

        } else {

            response.sendRedirect(
                    "booking.jsp");
        }
    }
}