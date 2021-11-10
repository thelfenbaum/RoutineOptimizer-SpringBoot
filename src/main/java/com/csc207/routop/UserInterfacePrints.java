package com.csc207.routop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserInterfacePrints {
    public static LocalDate getDate(Scanner reader){
        System.out.println("(Please enter date in format YYYY-MM-DD)");
        String startDate = reader.nextLine(); // Get user input
        int year = Integer.parseInt(startDate.substring(0, 4));
        int month = Integer.parseInt(startDate.substring(5, 7));
        int day = Integer.parseInt(startDate.substring(8, 10));
        return LocalDate.of(year, month, day);
    }

    public static LocalTime getTime(Scanner reader){
        System.out.println("(Please enter time in format HH:MM, where HH ranges from 00 to 23 and" +
                " where MM is either 00 or 30)");
        String startTime = reader.nextLine();  // Get user input
        int hour = Integer.parseInt(startTime.substring(0, 2));
        int minute = Integer.parseInt(startTime.substring(3, 5));
        return LocalTime.of(hour, minute);
    }
}
