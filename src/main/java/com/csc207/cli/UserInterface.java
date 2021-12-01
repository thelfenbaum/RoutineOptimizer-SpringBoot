package com.csc207.cli;
import com.csc207.api.*;
import com.csc207.domain.Project;
import com.csc207.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class is responsible for executing all the user interactions.
 */

@Service
public class UserInterface {
    @Autowired
    private UserController userController;
    @Autowired
    private WeekSerializableInteractorDataOut weekSerializableInteractor;
    @Autowired
    private UserInteractorDataOut userInteractor;
    @Autowired
    private WeekController weekController;
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;

    /**
     * The constructor for the UserInterface class.
     * @param uc: The user controller object to obtain the user from the database.
     * @param wsi: The week serializable interactor to obtain the week from the database.
     * @param ui: The user interactor to check the database.
     * @param tsido: The task serializable interactor to get data from the database.
     * @param wc: The week controller object to save week to a database.
     */
    public UserInterface(UserController uc, WeekSerializableInteractorDataOut wsi, UserInteractorDataOut ui,
                         TaskSerializableInteractorDataOut tsido, WeekController wc){
        this.userController = uc;
        this.weekSerializableInteractor = wsi;
        this.userInteractor = ui;
        this.taskSerializableInteractorDataOut = tsido;
        this.weekController = wc;
    }


    /**
     * Starts the program with a welcome message and checks whether the user wants to sign in or sign up.
     *
     * @param reader: the scanner for user input
     * @return the id for the user
     */
    public boolean signInOrSignUp(Scanner reader){
        UserInterfacePrints.printWelcomeMessage();
        String response = reader.nextLine(); // y or n
        if (Objects.equals(response, "y")){
            return true;
        }
        else if (Objects.equals(response, "n")){
            return false;
        }
        else{
            System.out.println("Please enter a valid option.");
            return signInOrSignUp(reader); // start again
        }
    }

    /**
     * Sign user up or in based on whether they have an account from previous input prompt.
     *
     * @param haveAccount: whether they have an account.
     * @param reader: the Scanner to get input.
     * @return the next method, which signs them in or up depending on their input.
     */
    public Long activateSignInOrSignUp(boolean haveAccount, Scanner reader){
        if (haveAccount){
            return signIn(reader);
        }
        else {
            return signUp(reader);
        }
    }

    /**
     * Signs a user in.
     *
     * @param reader: the scanner for user input.
     * @return the id for the user.
     */
    public long signIn(Scanner reader){
        System.out.println("Please enter your username.");
        String username = reader.nextLine();
        System.out.println("Please enter your password.");
        String password = reader.nextLine();
        if (this.userInteractor.checkSignIn(username, password)){ // checks whether the username and password exist and match up
            long userId = this.userInteractor.getUserIdByUsername(username);
            System.out.println(this.weekSerializableInteractor.getWeekSerializableByUserId(userId)); // show the user their week
            return userId;
        }
        else{
            System.out.println("Incorrect username or password. \n ");
//            System.out.println("Do you have an account with us? (y/n)");
//            return signInOrSignUp(reader); // start again
            return signIn(reader);
        }
    }

    /**
     * signs up a user
     *
     * @param reader: the scanner for user input
     * @return the id for the user
     */
    private long signUp(Scanner reader) {
        System.out.println("Please enter a username.");
        String username = reader.nextLine();
        System.out.println("Please enter a password.");
        UserInterfacePrints.printPasswordRequirements();
        String password = reader.nextLine();
        User newUser = new User(username, password);
        this.userController.saveUser(newUser);
        return newUser.getId();
    }

    /**
     * Gives a signed-in user the option to either create or import their week calendar.
     *  - If the user inputs 1, program creates a week calendar.
     *  - If the user inputs 2, program imports a week calendar.
     *
     * @param reader: The scanner in the Main module reading user input.
     * @return user's selected option as an integer.
     */
    public static int createOrImportWeek(Scanner reader){
        // Give instructions to the user
        UserInterfacePrints.createOrImportWeekMessage();
        String selectedOption = reader.nextLine();  // Read user input
        return Integer.parseInt(selectedOption);
    }

    /**
     * Gives a signed-up user the option to create a new week. Input mist be 1.
     *
     * @param reader: The scanner in the Main module reading user input.
     * @return user's selection option as an integer.
     */
    public static int createWeek(Scanner reader){
        // Give instructions to the user
        UserInterfacePrints.createWeekMessage();
        String selectedOption = reader.nextLine();
        return Integer.parseInt(selectedOption);
    }

    /** Takes the selection of the user and allows the user to create their schedule with the given week, start time,
     * or to import an existing schedule
     *
     * @param userId: the id of the user
     * @param selection: The selection of the user, whether they want to import or create their schedule
     * @param reader: The scanner in Main module reading user input
     */
    public Week activateCreateOrImport(long userId, int selection, Scanner reader){
        Week week;
        if (selection == 1) {
            LocalDate startDate = UserInterface.getStartDate(reader);
            Day[] days = DaysInjector.constructDayList(startDate);
            week = new Week(userId, days);
        } else if (selection == 2) { // use user id to retrieve the user's week serializable, convert it to week
            WeekSerializable weekSers = this.weekSerializableInteractor.getWeekSerializableByUserId(userId);
            this.weekSerializableInteractor.removeWeekSerializableByUserId(userId);
            ArrayList<TaskSerializable> tasksSers = this.taskSerializableInteractorDataOut.getTasksByUserId(userId);
            this.taskSerializableInteractorDataOut.removeTaskSerializablesByUserId(userId);
            week = SerializableToWeekAdapter.SerializableToWeek(weekSers, tasksSers);
        } else {
            System.out.println("Please enter a valid option.");
            int newSelection = Integer.parseInt(reader.nextLine());
            week = activateCreateOrImport(userId, newSelection, reader);
        }
        return week;
    }

    /**
     * Assuming user starts a new week, ask the user to choose on which date
     * they want their week to start.
     *
     * @param reader: The scanner in Main module reading user input
     * @return the date they input as a LocalDate object.
     */
    public static LocalDate getStartDate(Scanner reader){
        // Give user instructions
        try {
            System.out.println("On which day do you want your week to start?\n");
            return UserInterfaceExceptions.getDate(reader);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return getStartDate(reader);
        }
    }

    /**
     * Give the user the option of scheduling a type of duty.
     *  - If the user inputs 1, program schedules a FixedTask.
     *  - If the user inputs 2, program schedules a NonFixedTask.
     *  - If the user inputs 3, program schedules a project.
     *  - If the user inputs 4, program ends
     *
     * @param reader: The scanner in Main module reading user input
     * @return user's selected option as an integer.
     */
    public static int scheduleDuty(Scanner reader){
        // Scanner reader = new Scanner(System.in);  // Create a Scanner object
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
     * @param reader: The scanner in Main module reading user input
     * @return the FixedTask that is to be put in the schedule.
     */
    public static FixedTask createFixedTask(Scanner reader, Long userId){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        try{
            System.out.println("What is the name of your task or event?");

        String name = reader.nextLine(); // Get user input

        System.out.println("On what date does your task or event to take place?");
        LocalDate date = UserInterfaceExceptions.getDate(reader);

        System.out.println("At what time does your task or event begin?");
        LocalTime time = UserInterfaceExceptions.getTime(reader);
        LocalDateTime startDateTime = LocalDateTime.of(date, time);

        System.out.println("What is the duration of this task or event?");
        LocalTime duration = UserInterfaceExceptions.getTime(reader);

        return new FixedTask(name, startDateTime, duration, userId);  // Create a FixedTask from this information
        }
        catch(Exception exception) {
            System.out.println(exception.getMessage());
            return createFixedTask(reader, userId);
        }
    }


    /**
     * Get info from user about the NonFixedTask that they want to schedule and return the Task.
     *
     * @param reader: The scanner in Main module reading user input
     * @return the NonFixedTask that is to be put in the schedule.
     */
    public static NonFixedTask createNonFixedTask(Scanner reader, Long userId){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        try {
            System.out.println("What is the name of your task or event?");
            String name = reader.nextLine(); // Get user input

            System.out.println("What is the duration of your task or event?");
            LocalTime duration = UserInterfaceExceptions.getTime(reader); // get task duration

            System.out.println("Please enter the date that this task or event is due before.\n");
            LocalDate dueDate = UserInterfaceExceptions.getDate(reader);

            System.out.println("At what time on that day is your task or event due before?\n");
            LocalTime dueTime = UserInterfaceExceptions.getTime(reader);

            LocalDateTime dueDateTime = LocalDateTime.of(dueDate, dueTime);
            return new NonFixedTask(name, dueDateTime, duration, userId);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return createNonFixedTask(reader, userId);
        }
    }

    /**
     * Get info from user about the project they want to schedule, and return an array of NonFixedTasks
     * corresponding to the project.
     *
     * @param week: The week in which the nonFixedTask is being scheduled
     * @param reader: The scanner in Main module reading user input
     * @return an array of unscheduled NonFixedTasks corresponding to this project.
     */
    public static NonFixedTask[] createProject(Week week, Scanner reader){
        //Scanner reader = new Scanner(System.in);  // Create a Scanner object
        try {
            System.out.println("What is the name of your project or goal?");

            String name = reader.nextLine(); // Get user input

            System.out.println("What date do you want to start working on this project or goal?\n");
            LocalDate startDate = UserInterfaceExceptions.getDate(reader);

            LocalDateTime dueDateTime = getDueDateTime(reader);

            LocalTime maxHoursPerTask = getMaxHoursPerTask(week, reader, startDate, dueDateTime);

            NonFixedTask[] projectTasks = new NonFixedTask[7];
            for (int i = 0; i < 7; i++) {
                projectTasks[i] = new NonFixedTask(name, dueDateTime, maxHoursPerTask, week.getUserId());
            }
            return projectTasks;
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return createProject(week, reader);
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

    /** Helper method for createProject which gathers information about the project due date and time
     *
     * @param reader: The scanner in Main module reading user input
     * @return the LocalDateTime object representing the due date for the project
     */
    private static LocalDateTime getDueDateTime(Scanner reader) {
        try {
            System.out.println("What date is this project or goal due by?");

            LocalDate dueDate = UserInterfaceExceptions.getDate(reader);

            System.out.println("At what time on that day is your project or goal due before? \n");
            LocalTime dueTime = UserInterfaceExceptions.getTime(reader);

            return LocalDateTime.of(dueDate, dueTime);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return getDueDateTime(reader);
        }
    }
    /** Helper method for createProject which gathers information about the maximum amount of time the user can spend
     * on the project at a time
     *
     * @param reader: The scanner in Main module reading user input
     * @param week: the week into which the project is being scheduled
     * @return the LocalTime object representing the maximum amount of hours the user is willing to spend on the project
     * at a time
     */
    private static LocalTime getMaxHoursPerTask(Week week, Scanner reader, LocalDate startDate, LocalDateTime dueDateTime)
    {
        try {
            System.out.println("What is the total number of hours you would like to work on this project? (round to the" +
                    " nearest 0.5)");

            double totalHours = Double.parseDouble(reader.nextLine());
            double minHours = Project.calculateMinHours(week, startDate, dueDateTime, totalHours, 7);
            // Create case to handle when minHours is 0.0
            double maxHours = Project.calculateMaxHoursWeek(week);
            System.out.println("You must work on this project at least " + minHours + " per day and at most " + maxHours +
                    " per day.");
            System.out.println("Please enter the maximum amount of time you would like to work on this project in a given" +
                    "day.");
            return UserInterfaceExceptions.getTime(reader);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return getMaxHoursPerTask(week, reader, startDate, dueDateTime);
        }
    }

    /**
     * Helper method for schedulingDecision. Executes code for when the user selects selection 3.
     * @param week: The week that the user wants to schedule their project.
     * @param reader: The Scanner object to take in inputs.
     */
    private void selectsThree(Week week, Scanner reader) {
        NonFixedTask[] projectTasksToSchedule = UserInterface.createProject(week, reader);
        if(!Controller.checkProjectScheduling(week, projectTasksToSchedule)){
            System.out.println("This project can't be scheduled");}
        else{Controller.activateProjectScheduling(week, projectTasksToSchedule);}
    }

    /**
     * Helper method for schedulingDecision. Executes code for when the user selects selection 2.
     * @param week: The week that the user wants to schedule their NonFixedTask.
     * @param reader: The Scanner object to take in inputs.
     */
    private void selectsTwo(Week week, Scanner reader) {
        NonFixedTask taskToSchedule = UserInterface.createNonFixedTask(reader, week.getUserId());
        if(!Controller.checkNonFixedTaskScheduling(week, taskToSchedule)){
            System.out.println("This task can't be scheduled");}
        else{Controller.activateNonFixedTaskScheduling(week, taskToSchedule);}
    }

    /**
     * Helper method for schedulingDecision. Executes code for when the user selects selection 1.
     * @param week: The week that the user wants to schedule their FixedTask.
     * @param reader: The Scanner object to take in inputs.
     */
    private void selectsOne(Week week, Scanner reader) {
        FixedTask taskToPut = UserInterface.createFixedTask(reader, week.getUserId());
        if(!Controller.checkFixedTaskScheduling(week, taskToPut)){
            System.out.println("This task can't be scheduled");}
        else{Controller.activateFixedTaskScheduling(week, taskToPut);}
    }

}


