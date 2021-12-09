package com.csc207.cli;

import com.csc207.api.*;
import com.csc207.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Scanner;

@Service
public class UserChoiceBuilder {

    @Autowired
    private final WeekController weekController;
    @Autowired
    private final ProjectController projectController;

    /**
     * The constructor for the UserChoiceBuilder class.
     * @param wc : The week controller object to save week to a database.
     * @param projectController: the project controller object that handles processes associated with creating proects.
     */
    public UserChoiceBuilder(WeekController wc, ProjectController projectController){
        this.weekController = wc;
        this.projectController = projectController;
    }

    /** Takes the selection of the user and allows the user to create their schedule with the given week, start time,
     * or to import an existing schedule
     *
     * @param userId: the id of the user
     * @param selection: The selection of the user, whether they want to import or create their schedule
     * @param reader: The scanner in Main module reading user input
     */
    public void implementCreateOrImport(long userId, int selection, Scanner reader){
        if (selection == 1) {
            UserInterfaceCreates.createWeek(userId, reader);
        } else if (selection == 2) { // use user id to retrieve the user's week serializable, convert it to week
            this.projectController.importWeek(userId);
        }
    }

    /** Takes the selection and week that is given and finds whether what type of task is needed to be scheduled and
     * schedules the task
     *
     * @param week: the week that the task will be scheduled in
     * @param selection: the selection from the user about which type of task they would like to put
     * @param reader: The scanner in Main module reading user input
     */
    public void schedulingDecision(Week week, int selection, Scanner reader){
        if (selection == 1) {
            selectsOne(week, reader);
        } else if (selection == 2) {
            selectsTwo(week, reader);
        } else if (selection == 3) {
            selectsThree(week, reader);
        } else if (selection == 4){
            // convert the week into WeekSerializable and TaskSerializable, and save to database
           this.weekController.saveWeek(week);
        } else {
            System.out.println("Please enter a valid option (1, 2, 3, or 4).");
        }
    }


    /**
     * Helper method for schedulingDecision. Executes code for when the user selects selection 3.
     * @param week: The week that the user wants to schedule their project.
     * @param reader: The Scanner object to take in inputs.
     */
    private static void selectsThree(Week week, Scanner reader) {
        NonFixedTask[] projectTasksToSchedule = UserInterfaceCreates.createProject(week, reader);
        if(!CheckerController.checkProjectScheduling(week, projectTasksToSchedule)){
            System.out.println("This project can't be scheduled");}
        else{
            SchedulingController.activateProjectScheduling(week, projectTasksToSchedule);}
    }

    /**
     * Helper method for schedulingDecision. Executes code for when the user selects selection 2.
     * @param week: The week that the user wants to schedule their NonFixedTask.
     * @param reader: The Scanner object to take in inputs.
     */
    private static void selectsTwo(Week week, Scanner reader) {
        NonFixedTask taskToSchedule = UserInterfaceCreates.createNonFixedTask(reader, week.getUserId());
        if(!CheckerController.checkNonFixedTaskScheduling(week, taskToSchedule)){
            System.out.println("This task can't be scheduled");}
        else{
            SchedulingController.activateNonFixedTaskScheduling(week, taskToSchedule);}
    }

    /**
     * Helper method for schedulingDecision. Executes code for when the user selects selection 1.
     * @param week: The week that the user wants to schedule their FixedTask.
     * @param reader: The Scanner object to take in inputs.
     */
    private static void selectsOne(Week week, Scanner reader) {
        FixedTask taskToPut = UserInterfaceCreates.createFixedTask(reader, week.getUserId());
        if(!CheckerController.checkFixedTaskScheduling(week, taskToPut)){
            System.out.println("This task can't be scheduled");}
        else{
            SchedulingController.activateFixedTaskScheduling(week, taskToPut);}
    }

}
