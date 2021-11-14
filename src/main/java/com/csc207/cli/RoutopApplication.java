package com.csc207.cli;

import entities.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
@Configuration
public class RoutopApplication implements CommandLineRunner {
    private UserInterface ui;

    public RoutopApplication(UserInterface ui){
        this.ui = ui;
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutopApplication.class, args);
    }

    @Override
    public void run(String... args){
        Scanner reader = new Scanner(System.in);
        Week week;
        UserInterface.welcomeMessage();
        long userId = this.ui.signInOrSignUp(reader);
        int createOrImportChoice = UserInterface.createOrImportWeek(reader);

        while(true){
            int selectionForScheduling = UserInterface.scheduleDuty(reader);
            if (selectionForScheduling == 4) {
                break;
            }
            week = this.ui.activateCreateOrImport(userId, createOrImportChoice, reader);
            this.ui.schedulingDecision(week, selectionForScheduling, reader);
        }
        reader.close();
    }

}
