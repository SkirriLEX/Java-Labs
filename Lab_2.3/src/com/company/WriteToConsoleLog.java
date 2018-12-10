package com.company;

//import our logger :)

public class WriteToConsoleLog {

    public static void writeConsole (String message, LogStatus ls){
        if (ls == LogStatus.error){
            System.err.print(message);
        }else {
            System.out.print(message);
        }
    }
    public static void writeLog (String message, LogStatus ls){ //maybe later \_O_/
        if (ls == LogStatus.error){                             //              |
            // logger send error :)                             //             _|_
        }else if (ls == LogStatus.debug){                       //           _/   \_
            // logger send debug :)
        }else if (ls == LogStatus.normal){
            // logger send simply message :)
        }
    }
    public static void writeConsoleAndLog (String message, LogStatus ls){
        writeConsole(message,ls);
        writeLog(message,ls); //  :)
    }
}
