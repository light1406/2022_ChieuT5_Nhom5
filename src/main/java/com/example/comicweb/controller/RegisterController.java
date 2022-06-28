package com.example.comicweb.controller;

import com.example.comicweb.dao.UserDao;
import com.example.comicweb.obj.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class RegisterController extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = UserDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("RegisterScreen.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tu code
        String username = null;
        String password = null;
        String name = null;
        int birthYear = 0;

        boolean rs = userDao.register(new User(username, password, name, birthYear));
        if (rs){
            //neu dang ky thanh cong thi chuyen sang trang gi do; vi du sang trang chu hoac trang dang nhap
        }else {
            //that bai thi chuyen qua trang gi do; vi di trang dang ky va hien thi thong bao that bai
        }
    }
}
