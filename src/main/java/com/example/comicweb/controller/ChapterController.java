package com.example.comicweb.controller;

import com.example.comicweb.connect.ComicDb;
import com.example.comicweb.dao.ComicDao;
import com.example.comicweb.obj.Chapter;
import com.example.comicweb.obj.Comic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChapterController", urlPatterns = "/chapter")
public class ChapterController extends HttpServlet {
    private ComicDao comicDao;

    @Override
    public void init() throws ServletException {
        super.init();
        comicDao = ComicDao.getInstance();
    }

    @Override//6.doGet(comic-id, chapter-id)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comicId = request.getParameter("comic-id");
        String chapterId = request.getParameter("chapter-id");
        Comic comic = comicDao.getComic(comicId);//7.getComic(comicId)
        Chapter chapter = comic.getChapter(chapterId);//8.getChapter(chapterId)
        request.setAttribute("comic", comic);
        request.setAttribute("chapter", chapter);
        request.getRequestDispatcher("ChapterScreen.jsp").forward(request, response);//9.forward()
    }
}
