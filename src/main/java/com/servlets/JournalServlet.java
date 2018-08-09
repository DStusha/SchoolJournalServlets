package com.servlets;

import com.dao.SchoolDayDAO;
import com.dao.SubjectDAO;
import com.models.SchoolDay;
import com.models.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class JournalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        String day = req.getParameter("day");
        int studClass = Integer.parseInt(req.getParameter("studClass"));
        SchoolDayDAO sd = new SchoolDayDAO();
        SchoolDay s = sd.getDataByDayAndClass(day,studClass);
        if(s!=null) {
            ArrayList<Subject> list = new ArrayList<>();
            if (s.getFirstlesson() != null) {
                list.add(s.getFirstlesson());
            }
            if (s.getSecondlesson() != null) {
                list.add(s.getSecondlesson());
            }
            if (s.getThirdlesson() != null) {
                list.add(s.getThirdlesson());
            }
            if (s.getFourthlesson() != null) {
                list.add(s.getFourthlesson());
            }
            if (s.getFifthlesson() != null) {
                list.add(s.getFifthlesson());
            }
            if (s.getSixthlesson() != null) {
                list.add(s.getSixthlesson());
            }
            req.setAttribute("schoolday", list);
            req.setAttribute("day", s.getDay());
        }
        req.setAttribute("ustype", type);
        req.setAttribute("cl", studClass);
        req.setAttribute("day", day);
        req.getRequestDispatcher("pages/viewJournalPage.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String forward = "";
        String action = req.getParameter("action");
        if (action != null) {
            SubjectDAO s = new SubjectDAO();
            if ((action.equalsIgnoreCase("mark"))||(action.equalsIgnoreCase("homework"))) {
                String date = req.getParameter("date");
                String week = new String(req.getParameter("week").getBytes("ISO-8859-1"), "UTF-8");
                String value = new String(req.getParameter("value").getBytes("ISO-8859-1"),"UTF-8");
                int cl = Integer.parseInt(req.getParameter("class"));
                int id = Integer.parseInt(req.getParameter("subjId"));
                req.setAttribute("edit", action);
                req.setAttribute("week", week);
                req.setAttribute("cl", cl);
                req.setAttribute("value", value);
                forward = "pages/editMarkAndHomeWorkPage.jsp";
                req.setAttribute("subject", s.getDataById(id));
            }
            else if (action.equalsIgnoreCase("addSchoolDay")) {
                forward = "pages/addSchoolDayPage.jsp";
            }
        }
        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

}

