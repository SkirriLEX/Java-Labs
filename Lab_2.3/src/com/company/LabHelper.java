package com.company;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LabHelper {


    public static String helpReadLine(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {

            line = br.readLine();

        } catch (IOException ioe) {

            WriteToConsoleLog.writeConsole("Can`t read your input string\n",LogStatus.error);

        }
        return line;
    }

    public static boolean helpCheckString(@NotNull String string){
        if (string.matches("[a-zA-Z]+")==true)
            return true;
        WriteToConsoleLog.writeConsole("\nThis line have unsupported symbols. Write correct word next time! ^-)\n",LogStatus.error);
        return false;
    }
    public static boolean helpCheckInteger(@NotNull String string){
        if (string.matches("[0-9]")==true)
            return true;
        WriteToConsoleLog.writeConsole("\nThis line have unsupported symbols or must have only one number. Write correct word next time! ^-)\n",LogStatus.error);
        return false;
    }
    public static boolean helpCheckDouble(@NotNull String string){
        if (string.matches("[0-9]+[.][0-9]+")==true)
            return true;
        WriteToConsoleLog.writeConsole("\nThis line have unsupported symbols or must have only one number. Write correct word next time! ^-)\n",LogStatus.error);
        return false;
    }

    public static String helpWileCheckConsoleReadString(String Message){
        while (true)
        {
            WriteToConsoleLog.writeConsole(Message,LogStatus.normal);
            String line = helpReadLine();
            if (helpCheckString(line)) {
                return line;
            }
        }
    }
    public static int helpWileCheckConsoleReadInteger(String Message){
        while (true)
        {
            WriteToConsoleLog.writeConsole(Message,LogStatus.normal);
            String line = helpReadLine();
            if (helpCheckInteger(line)) {
                return Integer.parseInt(line);
            }
        }
    }
    public static double helpWileCheckConsoleReadDouble(String Message){
        while (true)
        {
            WriteToConsoleLog.writeConsole(Message,LogStatus.normal);
            String line = helpReadLine();
            if (helpCheckInteger(line)) {
                return Double.parseDouble(line);
            }
        }
    }
}
