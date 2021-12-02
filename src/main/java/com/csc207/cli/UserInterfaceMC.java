package com.csc207.cli;

import java.util.Objects;
import java.util.Scanner;

public class UserInterfaceMC {


    /**
     * Starts the program with a welcome message and checks whether the user wants to sign in or sign up.
     *
     * @param reader: the scanner for user input
     * @return the id for the user
     */
    public boolean signInOrSignUp(Scanner reader){
        UserInterfacePrints.printWelcomeMessage();
        String response = reader.nextLine(); // y or n
        if (Objects.equals(response, "y")){
            return true;
        }
        else if (Objects.equals(response, "n")){
            return false;
        }
        else{
            System.out.println("Please enter a valid option.");
            return signInOrSignUp(reader); // start again
        }
    }


    /**
     * Give the user the option of scheduling a type of duty.
     *  - If the user inputs 1, program schedules a FixedTask.
     *  - If the user inputs 2, program schedules a NonFixedTask.
     *  - If the user inputs 3, program schedules a project.
     *  - If the user inputs 4, program ends
     *
     * @param reader: The scanner in Main module reading user input
     * @return user's selected option as an integer.
     */
    public static int scheduleDuty(Scanner reader){
        // Give user instructions
        UserInterfacePrints.scheduleOptionsMessage();
        String selectedOption = reader.nextLine(); // Get user input
        return Integer.parseInt(selectedOption);
    }

    /**
     * Gives a signed-in user the option to either create or import their week calendar.
     *  - If the user inputs 1, program creates a week calendar.
     *  - If the user inputs 2, program imports a week calendar.
     *
     * @param reader: The scanner in the Main module reading user input.
     * @return user's selected option as an integer.
     */
    public static int createOrImportWeek(Scanner reader){
        // Give instructions to the user
        UserInterfacePrints.createOrImportWeekMessage();
        String selectedOption = reader.nextLine();  // Read user input
        return Integer.parseInt(selectedOption);
    }


}
