package com.dao;

import com.models.SchoolDay;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SchoolDayDAO {
    private Properties prop;
    private String connectionUrl;
    private String user;
    private String password;

    public SchoolDayDAO() throws IOException {
        prop = new Properties();
        InputStream fis = SchoolDayDAO.class.getClassLoader().getResourceAsStream("dbprop.prop");
        prop.load(fis);
        connectionUrl = prop.getProperty("jdbc")+prop.getProperty("instance")+prop.getProperty("dbName")+"?"+prop.getProperty("flags");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    public void addSchoolDay(SchoolDay s){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, this.user, password);
            String SQL = "INSERT INTO schooldays (day,class) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, s.getDay());
            st.setInt(2,s.getStudClass());
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }

    public SchoolDay getDataByDayAndClass(String day, int cl) {
    SchoolDay s = null;
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL = "SELECT * FROM schooldays WHERE  day = ? AND class = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, day);
            st.setInt(2, cl);
            ResultSet rs = st.executeQuery();
            SubjectDAO sb = new SubjectDAO();
            while (rs.next()){
                s = new SchoolDay(rs.getInt(1),rs.getInt(3), rs.getString(2), sb.getDataByDayAndLesson(rs.getInt(1),1),sb.getDataByDayAndLesson(rs.getInt(1),2),sb.getDataByDayAndLesson(rs.getInt(1),3),sb.getDataByDayAndLesson(rs.getInt(1),4),sb.getDataByDayAndLesson(rs.getInt(1),5),sb.getDataByDayAndLesson(rs.getInt(1),6));
            }
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void updateDay(int id, String day){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL="UPDATE schooldays SET day = ?  WHERE idschoolday = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1,day);
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
