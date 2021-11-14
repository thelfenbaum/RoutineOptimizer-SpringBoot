package com.csc207.cli;

import entities.Week;

import java.util.Scanner;
//import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Week week;
        UserInterface.welcomeMessage();
        long userId = UserInterface.signInOrSignUp(reader);
        int createOrImportChoice = UserInterface.createOrImportWeek(reader);

        while(true){
            int selectionForScheduling = UserInterface.scheduleDuty(reader);
            if (selectionForScheduling == 4) {
                break;
            }
            week = UserInterface.activateCreateOrImport(userId, createOrImportChoice, reader);
            UserInterface.schedulingDecision(week, selectionForScheduling, reader);
        }
        reader.close();
  }
}
