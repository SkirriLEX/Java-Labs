package com.company;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static  ArrayList<Gradebook> gradebooksList= new ArrayList<Gradebook>();

    public static void main(String[] args) {

        WriteToConsoleLog.writeConsole("Kirill_Andriets lab_2.3\n",LogStatus.normal);
        while (true)
        {
            helpDrawMenu();

            helpSelectMenu();
        }
    }

    public static void setConsoleData () {

        Gradebook gradebook = new Gradebook();
        WriteToConsoleLog.writeConsole("__________New_Student___________\n" +
                "Enter data FIO\n",LogStatus.normal);
        gradebook.setName(LabHelper.helpWileCheckConsoleReadString("Name : "));
        gradebook.setSurName(LabHelper.helpWileCheckConsoleReadString("Sur Name : "));
        gradebook.setEndName(LabHelper.helpWileCheckConsoleReadString("End Name : "));
        gradebook.setCurseNumber(LabHelper.helpWileCheckConsoleReadInteger("End Name : "));


        WriteToConsoleLog.writeConsole("____Exam____\n" +
                "How much that students have : ",LogStatus.normal);

        String examNum = LabHelper.helpReadLine();
        if (examNum.matches("[0-9]")) {
            WriteToConsoleLog.writeConsole(examNum+"\n",LogStatus.normal);
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < (Integer.parseInt(examNum)); i++) {
                arr.add(LabHelper.helpWileCheckConsoleReadString("Write name of Exam" + (i+1) + " : "));
            }
            gradebook.setListOfExamination(arr);
        }

        gradebook.setAverageForTheSession(LabHelper.helpWileCheckConsoleReadDouble("Average For The Session : "));

        gradebooksList.add(gradebook);
        WriteToConsoleLog.writeConsole("Added complited. All data is checked.\n",LogStatus.normal);
    }

    public static void defSetup (){
        List<String> defExamination= new ArrayList<>();
        defExamination.add("Operation System");
        defExamination.add("KPZ");
        defExamination.add("Exam1");
        defExamination.add("Exam2");
        defExamination.add("Exam3");

        Gradebook ivan = new Gradebook("Ivan","Ivanko","Ivanovich",1,defExamination,5);
        Gradebook vasya = new Gradebook("Vasya","Vasyko","Vasykovich",2,defExamination,3);
        Gradebook kolya = new Gradebook("Kolya","Kolenko","Nikolayonovich",1,defExamination,2);
        Gradebook pots = new Gradebook("noname","secret","incognito",3,defExamination,5);
        Gradebook ira = new Gradebook("ira","kovalenko","Vasykovech",2,defExamination,5);

        gradebooksList.add(ivan);
        gradebooksList.add(vasya);
        gradebooksList.add(kolya);
        gradebooksList.add(pots);
        gradebooksList.add(ira);

        WriteToConsoleLog.writeConsole("Default Setup added\n",LogStatus.normal);
    }

    public static void getStudentAvarageFromTheSesion(){
        WriteToConsoleLog.writeConsole("\n\n________________________________________\n",LogStatus.normal);
        double averageNum = LabHelper.helpWileCheckConsoleReadDouble("More then what mark do you want to know : ");

        String answer = "";
        for (Gradebook student:gradebooksList){
            if (student.getAverageForTheSession() > averageNum){
                answer += " - "+student.getName() + " "+ student.getSurName()+ " " + student.getEndName()+" he(she) have(has) :"+student.getAverageForTheSession()+"\n";
            }
        }
        WriteToConsoleLog.writeConsole(answer,LogStatus.normal);
        if (answer == null){
            WriteToConsoleLog.writeConsole("Sorry, I haven`t any answers",LogStatus.error);
        }

    }

    public static void getExamsForSpecialStudent() {

        String nameStudent = LabHelper.helpWileCheckConsoleReadString("Enter name of student : ");
        int curseNumber = LabHelper.helpWileCheckConsoleReadInteger("Enter student curse : ");

        String answer = null;
        for (Gradebook student : gradebooksList) {
            if (student.getCurseNumber() == curseNumber && student.getName() == nameStudent) {
                answer += nameStudent + " have exam - (";
                for (String exam : student.getListOfExamination()) {
                    answer += exam + ",";
                }
                answer += "\b)";
            }
        }
        WriteToConsoleLog.writeConsole(answer,LogStatus.normal);
        if (answer == null) {
            WriteToConsoleLog.writeConsole("Sorry, I haven`t any answers",LogStatus.error);
        }
    }

    public static void helpDrawMenu(){
        WriteToConsoleLog.writeConsole("\n\n__________Gradebook_List__________\n",LogStatus.normal);

        WriteToConsoleLog.writeConsole("What do you want to do (0-9)\n" +
                "0 - load Def Setup\n" +
                "1 - Show Students Average score\n" +
                "2 - Show Show exams for the speсial student\n" +
                "3 - add new Student\n" +
                "4 - finish program\n",LogStatus.normal);
    }
    public static void helpSelectMenu(){

        String choice = LabHelper.helpReadLine();
        switch (choice) {
            case "0": defSetup();
                break;
            case "1": getStudentAvarageFromTheSesion();
                break;
            case "2": getExamsForSpecialStudent ();
                break;
            case "3": setConsoleData ();
                break;
            case "4":  System.exit(0);
                break;
            default: WriteToConsoleLog.writeConsole("Invalid data :"+choice+"\n Try again\n",LogStatus.error);
                break;
        }
    }
}
