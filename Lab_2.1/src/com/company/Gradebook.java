package com.company;
import java.io.IOException;
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
    private double averageForTheSession;
    public Gradebook(){

    }
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
    public double getAverageForTheSession() {return averageForTheSession;}

    public void setName(String value){
        try {
            this.name = value;
        } catch (Throwable throwable){
            System.out.println();
        }
    }
    public void setSurName(String value){
        try {
            this.surName= value;
        } catch (Throwable throwable){
            System.out.println();
        }
    }
    public void setEndName(String value){
        try {
            this.endName = value;
        } catch (Throwable throwable){
            System.out.println();
        }
    }
    public void setCurseNumber(int value){
        try {
            this.curseNumber = value;
        } catch (Throwable throwable){
            System.out.println();
        }
    }
    public void setListOfExamination(List<String> value){
        try {
            this.listOfExamination = value;
        } catch (Throwable throwable){
            System.out.println();
        }
    }
    public void setAverageForTheSession(double value) {
        try {
            this.averageForTheSession = value;
        } catch (Throwable throwable){
            System.out.println();
        }
    }

}
