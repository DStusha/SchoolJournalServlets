package com.models;

public class SchoolDay {
    private int id;
    private String day;
    private int studClass;
    private Subject firstlesson;
    private Subject secondlesson;
    private Subject thirdlesson;
    private Subject fourthlesson;
    private Subject fifthlesson;
    private Subject sixthlesson;

    public SchoolDay(int id, int cl, String day, Subject firstlesson, Subject secondlesson, Subject thirdlesson,
                     Subject fourthlesson, Subject fifthlesson, Subject sixthlesson){
        this.id = id;
        this.day = day;
        this.studClass = cl;
        this.firstlesson = firstlesson;
        this.secondlesson = secondlesson;
        this.thirdlesson = thirdlesson;
        this.fourthlesson = fourthlesson;
        this.fifthlesson = fifthlesson;
        this.sixthlesson = sixthlesson;
    }

    public SchoolDay( int cl, String day){
        this.day = day;
        this.studClass = cl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Subject getFirstlesson() {
        return firstlesson;
    }

    public void setFirstlesson(Subject firstlesson) {
        this.firstlesson = firstlesson;
    }

    public Subject getSecondlesson() {
        return secondlesson;
    }

    public void setSecondlesson(Subject secondlesson) {
        this.secondlesson = secondlesson;
    }

    public Subject getThirdlesson() {
        return thirdlesson;
    }

    public void setThirdlesson(Subject thirdlesson) {
        this.thirdlesson = thirdlesson;
    }

    public Subject getFourthlesson() {
        return fourthlesson;
    }

    public void setFourthlesson(Subject fourthlesson) {
        this.fourthlesson = fourthlesson;
    }

    public Subject getFifthlesson() {
        return fifthlesson;
    }

    public void setFifthlesson(Subject fifthlesson) {
        this.fifthlesson = fifthlesson;
    }

    public Subject getSixthlesson() {
        return sixthlesson;
    }

    public void setSixthlesson(Subject sixthlesson) {
        this.sixthlesson = sixthlesson;
    }

    public int getStudClass() {
        return studClass;
    }

    public void setStudClass(int studClass) {
        this.studClass = studClass;
    }
}
