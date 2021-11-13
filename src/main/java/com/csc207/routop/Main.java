package com.csc207.routop;

import accessingdatajpa.UserInteractor;

import java.time.LocalDate;
import java.util.Scanner;
//import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        UserInterface.welcomeMessage();
        long userId = UserInterface.signInOrSignUp(reader);
        int createOrImportChoice = UserInterface.createOrImportWeek(reader);
        LocalDate startDate = UserInterface.getStartDate(reader); // gets the start date for the week assuming they
        // create it
        Week week = new Week(startDate, userId);
        while(true){
            int selectionForScheduling = UserInterface.scheduleDuty(reader);
            if (selectionForScheduling == 4) {
                break;
            }
            UserInterface.activateCreateOrImport(week, createOrImportChoice, selectionForScheduling, reader);
        }
        reader.close();
  }
}
