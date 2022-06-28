package com.example.comicweb.controller;

import com.example.comicweb.dao.ComicDao;
import com.example.comicweb.obj.Comic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ComicDetailComtroller", urlPatterns = "/comic-detail")
public class ComicDetailController extends HttpServlet {
    private ComicDao comicDao;

    @Override
    public void init() throws ServletException {
        super.init();
        comicDao = ComicDao.getInstance();
    }

    @Override//2.goGet(comic-id)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comicId = request.getParameter("comic-id");
        Comic comic = comicDao.getComic(comicId); // 3.getComic(comicId)
        request.setAttribute("comic", comic);
        request.getRequestDispatcher("ComicDetailScreen.jsp").forward(request,response);//4. forward()
    }
}
