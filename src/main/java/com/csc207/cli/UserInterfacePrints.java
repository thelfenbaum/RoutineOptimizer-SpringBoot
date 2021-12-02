package com.csc207.cli;

/**
 * This class is responsible for containing all the messages that will be printed out to the user.
 */

public class UserInterfacePrints {




    /**
     * Options presented to user for whether they want to create a new week or get one.
     */
    public static void createWeekMessage(){
        System.out.println("Let's begin. Enter 1 to start a new week schedule");
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


}
