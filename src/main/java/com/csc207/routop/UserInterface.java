package com.csc207.routop;

import org.apache.catalina.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class UserInterface {
    /**
     * Starts the calendar program. Prints a blurb regarding how to program works, and then
     * gives user the option to either create or import their week calendar.
     *  - If the user inputs 1, program creates a week calendar.
     *  - If the user inputs 2, program imports a week calendar.
     *
     * @return user's selected option as an integer.
     */
    public static int createOrImportWeek(Scanner reader){
        // Give background for the app and instructions for the user
        UserInterfacePrints.welcomeMessage();
        String selectedOption = reader.nextLine();  // Read user input
        return Integer.parseInt(selectedOption);
    }

    /** Takes the selection of the user and allows the user to create their schedule with the given week, start time,
     * or to import an existing schedule
     *
     * @param week: The week in which the schedule is being made for
     * @param selection: The selection of the user, whether they want to import or create their schedule
     * @param startDate: The day they would like to start their schedule
     * @param selectionForScheduling: The type of task they would like to put into their week
     */
    public static void activateCreateOrImport(Week week, int selection, LocalDate startDate, int selectionForScheduling, Scanner reader){
        if (selection == 1) {
            //Controller.activateInstantiateWeek(startDate);
            schedulingDecision(week, selectionForScheduling, reader);
            System.out.println(week);
        } else if (selection == 2) {
            System.out.println("This feature is not currently available.");
        } else {
            System.out.println("Please enter a valid option (1 or 2).");
        }
    }

    /**
     * Assuming user starts a new week, ask the user to choose on which date
     * they want their week to start.
     *
     * @return the date they input as a LocalDate object.
     */
    public static LocalDate getStartDate(Scanner reader){
        // Give user instructions
        System.out.println("On which day do you want your week to start?\n");
        return UserInterfacePrints.getDate(reader);
    }

    /**
     * Give the user the option of scheduling a type of duty.
     *  - If the user inputs 1, program schedules a FixedTask.
     *  - If the user inputs 2, program schedules a NonFixedTask.
     *  - If the user inputs 3, program schedules a project.
     *  - If the user inputs 4, program ends
     *
     * @return user's selected option as an integer.
     */
    public static int scheduleDuty(Scanner reader){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        // Give user instructions
        UserInterfacePrints.scheduleOptionsMessage();
        String selectedOption = reader.nextLine(); // Get user input
        return Integer.parseInt(selectedOption);
    }

    /**
     * Get info from user about the FixedTask that they want to schedule and return the Task.
     * Collect information from user about task they want to schedule and return a task according to their
     * specifications
     *
     * @return the FixedTask that is to be put in the schedule.
     */
    public static FixedTask createFixedTask(Scanner reader){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is the name of your task or event?");
        String name = reader.nextLine(); // Get user input

        System.out.println("On what date does your task or event to take place?");
        LocalDate date = UserInterfacePrints.getDate(reader);

        System.out.println("At what time does your task or event begin?");
        LocalTime time = UserInterfacePrints.getTime(reader);
        LocalDateTime startDateTime = LocalDateTime.of(date, time);

        System.out.println("What is the duration of this task or event?");
        LocalTime duration = UserInterfacePrints.getTime(reader);

        return new FixedTask(name, startDateTime, duration);  // Create a FixedTask from this information
    }


    /**
     * Get info from user about the NonFixedTask that they want to schedule and return the Task.
     *
     * @return the NonFixedTask that is to be put in the schedule.
     */
    public static NonFixedTask createNonFixedTask(Scanner reader){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is the name of your task or event?");
        String name = reader.nextLine(); // Get user input

        System.out.println("What is the duration of your task or event?");
        LocalTime duration = UserInterfacePrints.getTime(reader); // get task duration

        System.out.println("Please enter the date that this task or event is due before.\n");
        LocalDate dueDate = UserInterfacePrints.getDate(reader);

        System.out.println("At what time on that day is your task or event due before?\n");
        LocalTime dueTime = UserInterfacePrints.getTime(reader);

        LocalDateTime dueDateTime = LocalDateTime.of(dueDate, dueTime);
        return new NonFixedTask(name, dueDateTime, duration);
    }

    /**
     * Get info from user about the project they want to schedule, and return an array of NonFixedTasks
     * corresponding to the project.
     *
     * @return an array of unscheduled NonFixedTasks corresponding to this project.
     */
    public static NonFixedTask[] createProject(Week week, Scanner reader){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is the name of your project or goal?");
        String name = reader.nextLine(); // Get user input

        System.out.println("What date do you want to start working on this project or goal?\n");
        LocalDate startDate = UserInterfacePrints.getDate(reader);

        System.out.println("What date is this project or goal due by?");
        LocalDate dueDate = UserInterfacePrints.getDate(reader);

        System.out.println("At what time on that day is your project or goal due before? \n");
        LocalTime dueTime = UserInterfacePrints.getTime(reader);

        LocalDateTime dueDateTime = LocalDateTime.of(dueDate, dueTime);

        System.out.println("What is the total number of hours you would like to work on this project? (round to the" +
                " nearest 0.5)");
        double totalHours = Double.parseDouble(reader.nextLine());
        double minHours = Project.calculateMinHours(week, startDate, dueDateTime, totalHours, Constants.FREQUENCY);
        // Create case to handle when minHours is 0.0
        double maxHours = Project.calculateMaxHoursWeek(week);
        System.out.println("You must work on this project at least " + minHours + " per day and at most " + maxHours +
                " per day.");
        System.out.println("Please enter the maximum amount of time you would like to work on this project in a given" +
                "day. Enter a time formatted as HH:MM, where HH and MM are between that of the minimum and maximum" +
                "shown above.");
        String input = reader.nextLine();
        int hours = Integer.parseInt(input.substring(0, 2));
        int minutes = Integer.parseInt(input.substring(3, 5));
        LocalTime maxHoursPerTask = LocalTime.of(hours, minutes);
        NonFixedTask[] projectTasks = new NonFixedTask[Constants.FREQUENCY];
        for(int i = 0; i < 7; i++){
            projectTasks[i] = new NonFixedTask(name, dueDateTime, maxHoursPerTask);
        }
        return projectTasks;
    }

    /** Takes the selection and week that is given and finds whether what type of task is needed to be scheduled and
     * schedules the task
     *
     * @param week: the week that the task will be scheduled in
     * @param selection: the selection from the user about which type of task they would like to put
     */
    public static void schedulingDecision(Week week, int selection, Scanner reader){
        if (selection == 1) {
            FixedTask taskToPut = UserInterface.createFixedTask(reader);
            Controller.activateFixedTaskScheduling(week, taskToPut);
        } else if (selection == 2) {
            NonFixedTask taskToSchedule = UserInterface.createNonFixedTask(reader);
            Controller.activateNonFixedTaskScheduling(week, taskToSchedule);
        } else if (selection == 3) {
            NonFixedTask[] projectTasksToSchedule = UserInterface.createProject(week, reader);
            Controller.activateProjectScheduling(week, projectTasksToSchedule);
        } else {
            System.out.println("Please enter a valid option (1, 2, or 3).");
        }
    }



    // The unitTest gave an error saying that there was no main method in UI, so I added one     -Issam
    public static void main(String[] args) {

    }

}


