package com.example.comicweb.controller;

import com.example.comicweb.dao.ComicDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Home", urlPatterns = "/home")
public class HomeController extends HttpServlet {

    private ComicDao comicDao;

    @Override
    public void init() throws ServletException {
        super.init();
        comicDao = ComicDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("banner", comicDao.getBanner());
        req.setAttribute("new_update", comicDao.getNewUpdate());
        req.getRequestDispatcher("HomeScreen.jsp").forward(req, resp);
    }
}
