package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILENAME = "file.txt";

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;
        String input = "He";

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            List<String> zoom = new ArrayList<>();

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.indexOf(input) == 0){
                    zoom.add(sCurrentLine);
                }
            }

            for (String z : zoom) {
                System.out.println(z);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}