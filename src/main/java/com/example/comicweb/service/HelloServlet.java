package com.example.comicweb.service;

import com.example.comicweb.dao.ComicDao;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private ComicDao comicDao;

    public void init() {
        message = "Hello World!";
        comicDao = ComicDao.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> category = comicDao.getCategory("01");

        request.setAttribute("list", category);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}