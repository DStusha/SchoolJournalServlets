package com.dao;

import com.models.Subject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SubjectDAO {
    private Properties prop;
    private String connectionUrl;
    private String user;
    private String password;

    public SubjectDAO() throws IOException {
        prop = new Properties();
        InputStream fis = SubjectDAO.class.getClassLoader().getResourceAsStream("dbprop.prop");
        prop.load(fis);
        connectionUrl = prop.getProperty("jdbc")+prop.getProperty("instance")+prop.getProperty("dbName")+"?"+prop.getProperty("flags");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    public Subject getDataById(int id) {
        Subject s = null;
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL = "SELECT * FROM subjects WHERE idsubject = ? ";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                s = new Subject(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            }
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
        return s;
    }

    public void addSubject(Subject s){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, this.user, password);
            String SQL = "INSERT INTO subjects (subject, homework, idschoolday,numlesson) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, s.getName());
            st.setString(2, s.getHomework());
            st.setInt(3,s.getIdschoolday());
            st.setInt(4,s.getNumlesson());
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }

    public Subject getDataByDayAndLesson(int day,int lesson) {
        Subject s = null;
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL = "SELECT * FROM subjects WHERE idschoolday = ? AND numlesson = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, day);
            st.setInt(2, lesson);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                s = new Subject(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            }
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
        return s;
    }

    public void updateMark(int id, int mark){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL="UPDATE subjects SET mark = ?  WHERE idsubject = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, mark );
            st.setInt(2, id);
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }

    public void updateSubject(int id, String s){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL="UPDATE subjects SET subject = ?  WHERE idsubject = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, s);
            st.setInt(2, id);
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }

    public void updateHomeWork(int id, String work){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL="UPDATE subjects SET homework = ?  WHERE idsubject = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1,work );
            st.setInt(2, id);
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }
}
