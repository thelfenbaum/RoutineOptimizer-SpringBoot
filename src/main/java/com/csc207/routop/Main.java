package com.csc207.routop;

import java.time.LocalDate;
import java.util.Scanner;
//import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // Give user background on app and ask them whether they want to create
        // new week or import one from a .ics file
        int createOrImportChoice = UserInterface.createOrImportWeek(reader); // gets user input for whether they would like
        // create or import a week
        LocalDate startDate = UserInterface.getStartDate(reader); // gets the start date for the week assuming they create it
        // FixedTask taskToPut = UserInterface.createFixedTask(reader);
        // NonFixedTask taskToSchedule = UserInterface.createNonFixedTask(reader);
        Week week = new Week(startDate, userId);
        while(true){
            int selectionForScheduling = UserInterface.scheduleDuty(reader);
            UserInterface.activateCreateOrImport(week, createOrImportChoice, selectionForScheduling, reader);
            if (selectionForScheduling == 4) {
                break;
            }
        }
        reader.close();
  }
}
