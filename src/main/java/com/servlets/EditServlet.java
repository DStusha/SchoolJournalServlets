package com.servlets;

import com.dao.SchoolDayDAO;
import com.dao.SubjectDAO;
import com.models.SchoolDay;
import com.models.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        SubjectDAO s = new SubjectDAO();
        SchoolDayDAO sd = new SchoolDayDAO();
        int id;
        if(req.getParameter("markSave")!=null){
            id = Integer.parseInt(req.getParameter("id"));
            int mark = Integer.parseInt(req.getParameter("mark"));
            s.updateMark(id,mark);
            req.setAttribute("ustype", "teacher");
        }
        if(req.getParameter("workSave")!=null){
            id = Integer.parseInt(req.getParameter("id"));
            String work = req.getParameter("homework");
            s.updateHomeWork(id, work);
            req.setAttribute("ustype", "student");
        }
        if(req.getParameter("addDay")!=null){
            String weekDay = req.getParameter("day");
            int cl = Integer.parseInt(req.getParameter("studClass"));
            SchoolDay day = sd.getDataByDayAndClass(weekDay,cl);
            if(day==null){
                day = new SchoolDay(cl,weekDay);
                sd.addSchoolDay(day);
                day = sd.getDataByDayAndClass(weekDay,cl);
            }
            else{
                sd.updateDay(day.getId(),weekDay);
            }
                Subject firstlesson = s.getDataByDayAndLesson(day.getId(),1);
                Subject secondlesson = s.getDataByDayAndLesson(day.getId(),2);
                Subject thirdlesson = s.getDataByDayAndLesson(day.getId(),3);
                Subject fourthlesson = s.getDataByDayAndLesson(day.getId(),4);
                Subject fifthlesson = s.getDataByDayAndLesson(day.getId(),5);
                Subject sixthlesson = s.getDataByDayAndLesson(day.getId(),6);
                if(firstlesson !=null){
                    s.updateHomeWork(firstlesson.getId(),req.getParameter("firstHW"));
                    s.updateSubject(firstlesson.getId(),req.getParameter("first"));
                }else{
                    firstlesson = new Subject(req.getParameter("first"),req.getParameter("firstHW"), day.getId(),1);
                    s.addSubject(firstlesson);
                }
                if(secondlesson !=null){
                    s.updateHomeWork(secondlesson.getId(),req.getParameter("secondHW"));
                    s.updateSubject(secondlesson.getId(),req.getParameter("second"));
                }else{
                    s.addSubject(new Subject(req.getParameter("second"),req.getParameter("secondHW"), day.getId(),2));
                }
                if(thirdlesson !=null){
                    s.updateHomeWork(thirdlesson.getId(),req.getParameter("thirdHW"));
                    s.updateSubject(thirdlesson.getId(),req.getParameter("third"));
                }else{
                    s.addSubject(new Subject(req.getParameter("third"),req.getParameter("thirdHW"), day.getId(),3));
                }
                if(fourthlesson !=null){
                    s.updateHomeWork(fourthlesson.getId(),req.getParameter("fourthHW"));
                    s.updateSubject(fourthlesson.getId(),req.getParameter("fourth"));
                }else{
                    s.addSubject(new Subject(req.getParameter("fourth"),req.getParameter("fourthHW"), day.getId(),4));
                }
                if(fifthlesson !=null){
                    s.updateHomeWork(fifthlesson.getId(),req.getParameter("fifthHW"));
                    s.updateSubject(fifthlesson.getId(),req.getParameter("fifth"));
                }else{
                    s.addSubject(new Subject(req.getParameter("fifth"),req.getParameter("fifthHW"), day.getId(),5));
                }
                if(sixthlesson !=null){
                    s.updateHomeWork(sixthlesson.getId(),req.getParameter("sixthHW"));
                    s.updateSubject(sixthlesson.getId(),req.getParameter("sixth"));
                }else{
                    s.addSubject(new Subject(req.getParameter("sixth"),req.getParameter("sixthHW"), day.getId(),6));
                }
            req.setAttribute("ustype", "student");
        }
        req.getRequestDispatcher("pages/viewJournalPage.jsp").forward(req, resp);
    }
}
