package com.csc207.routop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserInterfacePrints {

    /**
     * Welcome message which greets user when they initiate the program
     */
    public static void welcomeMessage(){
        System.out.println("Hi there! Welcome to RoutOp, the app built for optimizing your week.");
        System.out.println("The app looks at your week's fixed schedule (for example: meetings, exercise, or " +
                "classes), and then schedules all your flexible duties in their optimal time slot. This way," +
                "RoutOp helps you maximize your executive output each week!");
    }

    public static void promptSignInOrSignUp(){
        System.out.println("Let's begin. Do you already have an account with us? (y/n)");
    }


    public static void promptUsernameInputSignIn(){
        System.out.println("Please enter your username.");
    }

    public static void promptPasswordInputSignIn(){
        System.out.println("Please enter your password.");
    }

    public static void promptUsernameInputSignUp(){
        System.out.println("Please enter a username.");
    }

    public static void promptPasswordInputSignUp(){
        System.out.println("Please enter a password.");
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
    public static LocalDate getDate(Scanner reader){
        System.out.println("(Please enter date in format YYYY-MM-DD)");
        String startDate = reader.nextLine(); // Get user input
        int year = Integer.parseInt(startDate.substring(0, 4));
        int month = Integer.parseInt(startDate.substring(5, 7));
        int day = Integer.parseInt(startDate.substring(8, 10));
        return LocalDate.of(year, month, day);
    }
    /**
     * Helper method UserInterface calls on to gather a time from the user
     * @param reader: Scanner in Main module reading user input
     * @return requested LocalTime object
     */
    public static LocalTime getTime(Scanner reader){
        System.out.println("(Please enter time in format HH:MM, where HH ranges from 00 to 23 and" +
                " where MM is either 00 or 30)");
        String startTime = reader.nextLine();  // Get user input
        int hour = Integer.parseInt(startTime.substring(0, 2));
        int minute = Integer.parseInt(startTime.substring(3, 5));
        return LocalTime.of(hour, minute);
    }


}
