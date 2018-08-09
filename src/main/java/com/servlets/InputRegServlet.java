package com.servlets;

import com.dao.UserDAO;
import com.models.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        UserDAO ud = new UserDAO();
        User u = null;
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        String type =  req.getParameter("usertype");
        req.setAttribute("ustype", type);
        if(req.getParameter("in")!= null){
            u = ud.getDataByLoginAndPassword(type,username,password);
            req.setAttribute("ifReg", "false");
            if(u!=null){
                req.getRequestDispatcher("pages/viewJournalPage.jsp").forward(req, resp);
            }
            else{
                req.setAttribute("ifNull", "true");
                req.getRequestDispatcher("pages/regInputPage.jsp").forward(req,resp);
            }
        }
        else{
            u = new User(username,password);
            ud.addUser(type,u);
            req.getRequestDispatcher("pages/viewJournalPage.jsp").forward(req, resp);
        }
    }
}
