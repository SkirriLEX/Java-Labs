package com.company;
import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();

        //Example of string
        // creator have five migrator and pullverizator

        inputString = inputString+" ";
        String[] parts = inputString.split("( ?=)");
        System.out.println(Arrays.toString(parts));


        System.out.print("Enter a old part: ");
        String oldPart = scanner. nextLine();
        System.out.print("Enter a need part : ");
        String needPart = scanner. nextLine();

        for (int i=0;i<parts.length;i++){
            parts[i] = parts[i].replace(oldPart+" ",needPart+" ");
        }
        for (int i=0;i<parts.length;i++){
            System.out.print(parts[i]);
        }
    }
}
