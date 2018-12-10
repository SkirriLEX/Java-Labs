package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private static final String FILENAME = "file.txt";

    public static void main(String[] args) {

        System.out.print("Enter read file path: ");
        String readFilePath = helpReadLine();

        System.out.print("Write write file path : ");
        String writeFilePath = helpReadLine();

        System.out.print("What do you want to search : ");
        String input = helpReadLine();

        List<String> file = new ArrayList<>();
        List<String> newfile = new ArrayList<>();

        try {

            file = readFileRead(readFilePath);

        } catch (IOException ioe){

            System.out.print("Cant Read file");

        }

        if (!(file == null)){
            System.out.print("______________");
            for (String f : file) {
                System.out.println(f);
                if (f.indexOf(input)==0){
                    System.err.println(f);
                    newfile.add(f);
                }
            }
        }

        try {

            writeFileWrite(newfile, writeFilePath);

        } catch (IOException oie){

            System.out.print("Cant Write file");

        }

    }
    public static List<String> readFileRead(String filepath) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String sCurrentLine;
        List<String> arr = new ArrayList<>();

        while ((sCurrentLine = reader.readLine()) != null) {
            arr.add(sCurrentLine);
        }
        reader.close();

        return arr;
    }
    public static void writeFileWrite(List<String> content,String filepath) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
        for (String c:content){
            writer.write(c);
        }
        writer.close();
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

}