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

        System.out.println("Kirill_Andriets lab_2.1");
        while (true)
        {
            helpDrawMenu();

            helpSelectMenu();
        }
    }

    public static void setConsoleData () {

        Gradebook gradebook = new Gradebook();
        System.out.println("__________New_Student___________\n" +
                "Enter data FIO");
        while (true) {
            System.out.print("Name : ");
            String line = helpReadLine();
            if (helpCheckString(line)) {
                gradebook.setName(line);
                break;
            }
        }
        while (true) {
            System.out.print("Sur Name : ");
            String line = helpReadLine();
            if (helpCheckString(line)) {
                gradebook.setSurName(line);
                break;
            }
        }
        while (true) {
            System.out.print("End Name : ");
            String line = helpReadLine();
            if (helpCheckString(line)) {
                gradebook.setEndName(line);
                break;
            }
        }
        while (true) {
            System.out.print("Current Course Number: ");
            String line = helpReadLine();
            if (helpCheckInteger(line)) {
                gradebook.setCurseNumber(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("____Exam____");
        System.out.print("How much that students have : ");
        String examNum = helpReadLine();
        if (examNum.matches("[0-9]")) {
            System.out.println(examNum);
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < (Integer.parseInt(examNum)); i++) {
                while (true) {
                    System.out.print("Write name of Exam" + (i+1) + " : ");
                    String examName = helpReadLine();
                    if (helpCheckString(examName)) {
                        arr.add(examName);
                        break;
                    }
                }
            }
            gradebook.setListOfExamination(arr);
        }
        while (true) {
            System.out.print("Average For The Session : ");
            String line = helpReadLine();
            if (helpCheckInteger(line)) {
                gradebook.setAverageForTheSession(Double.parseDouble(line));
                break;
            }
        }
        gradebooksList.add(gradebook);
        System.out.println("Added complited. All data is checked.");
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

        System.out.println("Default Setup added");
    }

    public static String helpReadLine(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {

            line = br.readLine();

        } catch (IOException ioe) {

            System.err.println("Can`t read your input string");

        }
        return line;
    }

    public static void getStudentAvarageFromTheSesion(){
        System.out.print("\n\n________________________________________\n");
        double averageNum;
        while (true)
        {
            System.out.print("More then what mark do you want to know : ");
            String line = helpReadLine();
            if (helpCheckDouble(line)) {
                averageNum = Double.parseDouble(line);
                break;
            }
        }
        String answer = null;
        for (Gradebook student:gradebooksList){
            if (student.getAverageForTheSession() > averageNum){
                answer += " - "+student.getName() + " "+ student.getSurName()+ " " + student.getEndName()+"\n";
            }
        }
        System.out.print(answer);
        if (answer == null){
            System.err.print("Sorry, I haven`t any answers");
        }

    }

    public static void getExamsForSpecialStudent(){
        String nameStudent;
        double curseNumber;
        while (true)
        {
            System.out.print("Enter name of student : ");
            String line = helpReadLine();
            if (helpCheckString(line)) {
                nameStudent = line;
                break;
            }
        }
        while (true)
        {
            System.out.print("Enter student curse : ");
            String line = helpReadLine();
            if (helpCheckInteger(line)) {
                curseNumber = Integer.parseInt(line);
                break;
            }
        }
        String answer = null;
        for (Gradebook student:gradebooksList){
            if (student.getCurseNumber() == curseNumber  && student.getName() == nameStudent){
                answer += nameStudent + " have exam - (";
                for (String exam: student.getListOfExamination()){
                    answer+= exam+",";
                }
                answer+="\b)";
            }
        }
        System.out.print(answer);
        if (answer == null){
            System.err.print("Sorry, I haven`t any answers");
        }
    }

    public static boolean helpCheckString(@NotNull String string){
        if (string.matches("[a-zA-Z]+")==true)
            return true;
        System.err.println("\nThis line have unsupported symbols. Write correct word next time! ^-)");
        return false;
    }
    public static boolean helpCheckInteger(@NotNull String string){
        if (string.matches("[0-9]")==true)
            return true;
        System.err.println("\nThis line have unsupported symbols or must have only one number. Write correct word next time! ^-)");
        return false;
    }
    public static boolean helpCheckDouble(@NotNull String string){
        if (string.matches("[0-9]+[.][0-9]+")==true)
            return true;
        System.err.println("\nThis line have unsupported symbols or must have only one number. Write correct word next time! ^-)");
        return false;
    }

    public static void helpDrawMenu(){
        System.out.println("\n\n__________Gradebook_List__________");

        System.out.print("What do you want to do (0-9)\n" +
                "0 - load Def Setup\n" +
                "1 - Show Students Average score\n" +
                "2 - Show Show exams for the speсial student\n" +
                "3 - add new Student\n" +
                "4 - finish program\n");
    }
    public static void helpSelectMenu(){

        String choice = helpReadLine();
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
            default: System.err.println("Invalid data :"+choice+"\n Try again");
                break;
        }
    }
}
