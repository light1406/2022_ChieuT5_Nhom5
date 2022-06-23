package com.example.comicweb.controller;

import com.example.comicweb.dao.ComicDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ComicDetailComtroller", urlPatterns = "/comic-detail")
public class ComicDetailComtroller extends HttpServlet {
    private ComicDao comicDao;

    @Override
    public void init() throws ServletException {
        super.init();
        comicDao = ComicDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comicId = request.getParameter("comic-id");
        request.setAttribute("comic", comicDao.getComic(comicId));
        request.getRequestDispatcher(request.getContextPath() + "/ComicDetailScreen.jsp").forward(request,response);
    }
}
