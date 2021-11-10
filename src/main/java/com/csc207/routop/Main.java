package com.csc207.routop;

import java.time.LocalDate;
//import java.time.DayOfWeek;

public class Main {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        // Give user background on app and ask them whether they want to create
        // new week or import one from a .ics file
        int createOrImportChoice = UserInterface.createOrImportWeek(); // gets user input for whether they would like
        // create or import a week
        LocalDate startDate = UserInterface.getStartDate(); // gets the start date for the week assuming they create it
//        FixedTask taskToPut = UserInterface.createFixedTask();
//        NonFixedTask taskToSchedule = UserInterface.createNonFixedTask();
        Week week = Controller.activateInstantiateWeek(startDate);
        while(true){
            int selectionForScheduling = UserInterface.scheduleDuty();
            UserInterface.activateCreateOrImport(week, createOrImportChoice, startDate, selectionForScheduling);
        }
    }
}
