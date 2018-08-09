package com.dao;
import com.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class UserDAO {
    private Properties prop;
    private String connectionUrl;
    private String user;
    private String password;

    public UserDAO() throws IOException {
        prop = new Properties();
        InputStream fis = UserDAO.class.getClassLoader().getResourceAsStream("dbprop.prop");
        prop.load(fis);
        connectionUrl = prop.getProperty("jdbc")+prop.getProperty("instance")+prop.getProperty("dbName")+"?"+prop.getProperty("flags");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }
    public ArrayList<User> getAllDataFromTable(String type)  {
        ArrayList<User> list = new ArrayList<User>();
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL = null;
            if (type.equalsIgnoreCase("student")){
                SQL = "SELECT * FROM students";
            }
            else {
                SQL = "SELECT * FROM teachers";
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()){
                User user = new User(rs.getString(1),  rs.getString(3));
                list.add(user);
            }
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
        return list;
    }

    public User getDataByLoginAndPassword(String type, String log, String pas) {
        User stud = null;
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL = null;
            if (type.equalsIgnoreCase("student")){
                SQL = "SELECT * FROM students WHERE login = ? AND password =?";
            }
            else {
                SQL = "SELECT * FROM teachers WHERE login = ? AND password =?";
            }
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, log);
            st.setString(2, pas);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                stud = new User(rs.getString(1), rs.getString(3));
            }
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
        return stud;
    }

    public void addUser(String type, User user){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, this.user, password);
            String SQL;
            if (type.equalsIgnoreCase("student")){
                SQL = "INSERT INTO students (login, password) VALUES (?,?)";
            }else{
                SQL = "INSERT INTO teachers (login, password) VALUES (?,?)";
            }
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }

    public void deleteByLogin(String type, String log){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL;
            if (type.equalsIgnoreCase("student")){
                SQL = "DELETE FROM  students  WHERE login = ?";
            }else{
                SQL = "DELETE FROM teachers  WHERE login = ?";
            }
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, log);
            st.executeUpdate();
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }

    public void clearTable(String type){
        try {
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            String SQL = null;
            if (type.equalsIgnoreCase("student")){
                SQL = "DELETE FROM students";
            }
            else {
                SQL = "DELETE FROM teachers";
            }
            Statement st = con.createStatement();
            st.executeUpdate(SQL);
            con.close();
            st.close();
        }
        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }
    }
}
