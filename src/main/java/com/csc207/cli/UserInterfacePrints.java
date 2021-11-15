package com.csc207.cli;

public class UserInterfacePrints {

    /**
     * Welcome message which greets user when they initiate the program
     */
    public static void printWelcomeMessage(){
        System.out.println("Hi there! Welcome to RoutOp, the app built for optimizing your week.");
        System.out.println("The app looks at your week's fixed schedule (for example: meetings, exercise, or " +
                "classes), and then schedules all your flexible duties in their optimal time slot. This way," +
                "RoutOp helps you maximize your executive output each week! \n");
        System.out.println("Do you have an account with us? (y/n)");
    }

    /**
     * Prints password creation requirements.
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
     * Options presented to user for whether they want to create a new week or get one.
     */
    public static void createOrImportWeekMessage(){
        System.out.println("Let's begin. Enter");
        System.out.println("    - 1 to start a new week schedule");
        System.out.println("    - 2 use your previously saved week schedule");
    }

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
