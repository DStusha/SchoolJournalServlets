package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("inputBtn")!= null){
            req.setAttribute("ifReg", "false");
            req.setAttribute("ifNull", "false");
        }
        if(req.getParameter("regBtn")!= null){
            req.setAttribute("ifReg", "true");
            req.setAttribute("ifNull", "false");
        }
        req.getRequestDispatcher("pages/regInputPage.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/startPage.jsp").forward(req, resp);
    }
}
