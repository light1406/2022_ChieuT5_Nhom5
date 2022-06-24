package com.example.comicweb.controller;

import com.example.comicweb.dao.ComicDao;
import com.example.comicweb.obj.Comic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class SearchController extends HttpServlet {
    private ComicDao comicDao;

    @Override
    public void init() throws ServletException {
        super.init();
        comicDao = ComicDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Comic> comics = comicDao.searchComic(name);
        if (comics != null) {
            request.setAttribute("result", comics);
            RequestDispatcher rd = request.getRequestDispatcher("searchScreen.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("HomeScreen.jsp");
        }
    }

}
