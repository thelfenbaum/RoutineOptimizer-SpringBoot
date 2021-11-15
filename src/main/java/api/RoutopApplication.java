package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Scanner;

@SpringBootApplication
@EntityScan("api")
public class RoutopApplication implements CommandLineRunner {
    @Autowired
    private final UserInterface ui;

    public RoutopApplication(UserInterface ui){
        this.ui = ui;
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutopApplication.class, args);
    }

    @Override
    public void run(String... args){
        Scanner reader = new Scanner(System.in);
        UserInterface.welcomeMessage();
        long userId = this.ui.signInOrSignUp(reader);
        int createOrImportChoice = UserInterface.createOrImportWeek(reader);
        Week week = this.ui.activateCreateOrImport(userId, createOrImportChoice, reader);

        while(true){
            int selectionForScheduling = UserInterface.scheduleDuty(reader);
            this.ui.schedulingDecision(week, selectionForScheduling, reader);
            if (selectionForScheduling == 4) {
                break;
            }
        }
        reader.close();
    }

}
