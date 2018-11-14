package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.print("Kirrill_Andriets lab_3");

        List<String> defExamination= new ArrayList<>();
        defExamination.add("Operation System");
        defExamination.add("Exam1");
        defExamination.add("Exam2");
        defExamination.add("Exam3");

        Gradebook ivan = new Gradebook("Ivan","Ivanko","Ivanovich",1,defExamination,5);
        Gradebook vasya = new Gradebook("Vasya","Vasyko","Vasykovich",2,defExamination,3);
        Gradebook kolya = new Gradebook("Kolya","Kolenko","Nikolayonovich",1,defExamination,2);
        Gradebook pots = new Gradebook("noname","secret","incognito",3,defExamination,5);
        Gradebook ira = new Gradebook("ira","kovalenko","Vasykovech",2,defExamination,5);

        ArrayList<Gradebook> gradebooksList= new ArrayList<Gradebook>();
        gradebooksList.add(ivan);
        gradebooksList.add(vasya);
        gradebooksList.add(kolya);
        gradebooksList.add(pots);
        gradebooksList.add(ira);

        for (Gradebook student:gradebooksList){
            if (student.getAverageForTheSession() > 4.5){
                System.out.println(" - "+student.getName() + " "+ student.getSurName()+ " " + student.getEndName());
            }
        }

        System.out.println(" ");
        String nameStudent = "Vasya";
        for (Gradebook student:gradebooksList){
            if (student.getCurseNumber() == 2  && student.getName() == nameStudent){
                System.out.print( nameStudent + " have exam ");
                System.out.print(" - (");
                for (String exam: student.getListOfExamination()){
                    System.out.print(exam+",");
                }
                System.out.println("\b)");
            }
        }
        //ReadXML.main();
    }
}
