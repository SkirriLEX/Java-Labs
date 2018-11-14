package com.company;
import java.util.List;

public class Gradebook {
    @Override
    public String toString() {
        return super.toString();
    }
    private String name;
    private String surName;
    private String endName;
    private int curseNumber;
    private List<String> listOfExamination;
    private int averageForTheSession;
    public Gradebook(String name,String surName,String endName,int curseNumber,List<String> listOfExamination, int averageForTheSession) {
        this.name = name;
        this.surName = surName;
        this.endName = endName;
        this.curseNumber = curseNumber;
        this.listOfExamination = listOfExamination;
        this.averageForTheSession = averageForTheSession;
    }

    public String getName() {return name;}
    public String getSurName() {return surName;}
    public String getEndName() {return endName;}
    public int getCurseNumber() {return curseNumber;}
    public List<String> getListOfExamination() {return listOfExamination;}
    public int getAverageForTheSession() {return averageForTheSession;}
}
