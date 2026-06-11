package com.travel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.dao.UserDAO;
import com.travel.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();

        user.setUsername(
                request.getParameter("username"));

        user.setPassword(
                request.getParameter("password"));

        user.setEmail(
                request.getParameter("email"));

        user.setFullName(
                request.getParameter("fullname"));

        user.setPhone(
                request.getParameter("phone"));

        user.setAddress(
                request.getParameter("address"));

        UserDAO dao = new UserDAO();

        if(dao.registerUser(user)) {

            response.sendRedirect("login.jsp");

        } else {

            response.sendRedirect("register.jsp");
        }
    }
}