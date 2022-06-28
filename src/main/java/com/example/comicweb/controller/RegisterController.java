package com.example.comicweb.controller;

import com.example.comicweb.dao.UserDao;
import com.example.comicweb.obj.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Register", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fullName = request.getParameter("fullName");
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            String repass = request.getParameter("re-password");
            int birthYear = Integer.parseInt(request.getParameter("birthYear"));


            if (password.equals(repass)) {

                UserDao userDao = new UserDao();
                User a = userDao.checkUserExist(username);
                if (a == null) {

                    userDao.registry(fullName, password, username, birthYear);
                    response.sendRedirect("home");
                    PrintWriter pw = response.getWriter();


                } else {
                    request.setAttribute("error", "Tài khoản đăng ký đã tồn tại hoặc thông tin đăng ký không hợp lệ");
                    request.getRequestDispatcher("RegisterScreen.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("error", "Tài khoản đăng ký đã tồn tại hoặc thông tin đăng ký không hợp lệ");
                request.getRequestDispatcher("RegisterScreen.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("RegisterScreen.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
