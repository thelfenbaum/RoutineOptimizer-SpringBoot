package com.csc207.cli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterfacePrintsExceptions {
    /**
     * Helper method UserInterface calls on to gather a date from the user
     * @param reader: Scanner in Main module reading user input
     * @return requested LocalDate object
     * @throws Exception if the format is invalid
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

    /**
     * helper method for method getDate. This method checks if the string is
     * in the correct format
     * @param startDate: the date inputted by the user in string format
     * @throws Exception if the format is invalid
     */
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
     * @param reader: Scanner in Main module reading user input.
     * @return requested LocalTime object.
     * @throws Exception if the time is in invalid format.
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

    /**
     * helper method for getTime method, where the method checks if the format
     * is correct.
     *
     * @param startTime: the time inputted by the user in string.
     * @throws Exception if the time is in an invalid format
     */
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
