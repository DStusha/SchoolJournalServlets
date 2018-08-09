package com.models;

import java.util.Date;

public class Subject {
    private int id;
    private String name;
    private String homework;
    private int mark;
    private int idschoolday;
    private int numlesson;

    public Subject( int id, String subject, String homework, int mark, int idschoolday, int numlesson){
        this.id = id;
        this.name = subject;
        this.homework = homework;
        this.mark = mark;
        this.idschoolday = idschoolday;
        this.numlesson = numlesson;
    }

    public Subject( String subject, String homework, int idschoolday, int numlesson){
        this.name = subject;
        this.homework = homework;
        this.idschoolday = idschoolday;
        this.numlesson = numlesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String subject) {
        this.name = subject;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIdschoolday() {
        return idschoolday;
    }

    public void setIdschoolday(int idschoolday) {
        this.idschoolday = idschoolday;
    }

    public int getNumlesson() {
        return numlesson;
    }

    public void setNumlesson(int numlesson) {
        this.numlesson = numlesson;
    }
}
