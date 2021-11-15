package com.csc207.cli;

import org.apache.catalina.LifecycleState;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterfacePrints {
    /**
     * helper method for signing in process in UI
     * requirements for password when new user signs up
     */
    public static void printPasswordRequirements(){
        System.out.println("MUST contain at least 12 characters");
        System.out.println("MUST contain at least one uppercase letter");
        System.out.println("MUST contain at least one lowercase letter");
        System.out.println("MUST contain at least one number");
        System.out.println("MUST contain at least one special character");
        System.out.println("MUST not contain two or more identical characters in a row");
        System.out.println("MUST not match commonly used password patterns");
    }


    /**
     * Options presented to user for which kind of scheduling process they would like to initiate.
     * If they choose option 4, they exit the program
     */
    public static void createOrImportWeekMessage(){
        System.out.println("Let's begin. Enter");
        System.out.println("    - 1 to start a new week schedule");
        System.out.println("    - 2 to import a week schedule from a .ics file (feature coming soon)");
    }


    /**
     * Options presented to user for which kind of scheduling process they would like to initiate.
     * If they choose option 4, they exit the program
     */
    public static void scheduleOptionsMessage(){
        System.out.println("Schedule one or more duties. Enter:");
        System.out.println("    - 1 to schedule a task or event that is part of your week's fixed schedule");
        System.out.println("    - 2 to schedule a task or event that is flexible, which RoutOp will find the best" +
                "time slot for based on your fixed schedule.");
        System.out.println("    - 3 to enter information about a project or goal you are working towards, which " +
                "RoutOp will find time during the week for you to work on based on your fixed schedule as well " +
                "as the information you enter about the project.");
        System.out.println("    - 4 to exit the program");
    }

    /**
     * Helper method UserInterface calls on to gather a date from the user
     * @param reader: Scanner in Main module reading user input
     * @return requested LocalDate object
     */
    public static LocalDate getDate(Scanner reader) throws Exception{
        System.out.println("(Please enter date in format YYYY-MM-DD)");
        String startDate = reader.nextLine(); // Get user input

        checkError(startDate);


        int year = Integer.parseInt(startDate.substring(0, 4));
        int month = Integer.parseInt(startDate.substring(5, 7));
        int day = Integer.parseInt(startDate.substring(8, 10));

        return LocalDate.of(year, month, day);
    }

    private static void checkError(String startDate) throws Exception {
        for (int i = 0; i < startDate.length(); i++){
            if (i == 4 || i == 7){
                if (startDate.charAt(i) != '-'){
                    throw new Exception(Exceptions.INVALID_DATE_FORMAT);
                }
            }
            else{
                List<Character> list = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
                if (list.contains(startDate.charAt(i))){
                    throw new Exception(Exceptions.INVALID_DATE_FORMAT);
                }


            }
        }
    }

    /**
     * Helper method UserInterface calls on to gather a time from the user
     * @param reader: Scanner in Main module reading user input
     * @return requested LocalTime object
     */
    public static LocalTime getTime(Scanner reader) throws Exception{
        System.out.println("(Please enter time in format HH:MM, where HH ranges from 00 to 23 and" +
                " where MM is either 00 or 30)");
        String startTime = reader.nextLine();  // Get user input
        isValidTimeFormat(startTime);

        int hour = Integer.parseInt(startTime.substring(0, 2));
        int minute = Integer.parseInt(startTime.substring(3, 5));

        if (hour > 23 || hour < 0){
            throw new Exception(Exceptions.INVALID_TIME_FORMAT);
        }
        return LocalTime.of(hour, minute);
    }

    private static void isValidTimeFormat(String startTime) throws Exception {
        if (startTime.length() != 5){
            throw new Exception(Exceptions.INVALID_TIME_FORMAT);
        }
        for (int i = 0; i < startTime.length(); i++){
            if (i == 2){
                if (startTime.charAt(i) != ':'){
                    throw new Exception(Exceptions.INVALID_TIME_FORMAT);
                }
            }
            else{
                List<Character> list = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
                if (list.contains(startTime.charAt(i))){
                        throw new Exception(Exceptions.INVALID_TIME_FORMAT);
                    }

            }
        }
    }


}
