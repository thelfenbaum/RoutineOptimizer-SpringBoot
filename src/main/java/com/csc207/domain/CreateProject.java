package com.csc207.domain;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class allows you to gather information about creating project.
 */

public class CreateProject {

    /** Calculate the minimum number of hours in a week that a user must work on their project per given frequency, so
     * that the project can be finished before the due date
     *
     * @param week: the week the project is going to be scheduled in
     * @param startDate: The day the project will be started
     * @param dueDate: The day that the project will need to be finished by
     * @param totalHours: The total number of hours that the project will be worked on
     * @param frequency: The number of times the project will be worked on during the week
     * @return the minimum number of hours user must work on project per frequency to complete it in time. If
     *  there is not enough space in their week, return 0.0.
     */
    public static double calculateMinHours(Week week, LocalDate startDate, LocalDateTime dueDate, double totalHours,
                                    double frequency) {

        double idealChunk = getIdealChunk(startDate, dueDate, totalHours, frequency); //get the idealChunk
        if (fitSchedule(week, idealChunk)) { //check if the idealChunk fits in the schedule
            return idealChunk;
        }
        else {
            return 0.0;
        }
    }

    /** Finds the ideal chunk of time that a user must work on a project per day and returns the number of hours
     *
     * @param startDate: The day the project will be started on
     * @param dueDate: The day that the project needs to be completed by
     * @param totalHours: The total hours that the project will be worked on
     * @param frequency: the number of times in a week that a project will be worked on
     * @return The ideal chunk of time in hours a user must work on a project per day. If there is no ideal chunk, return 0.5
     */
     public static double getIdealChunk(LocalDate startDate, LocalDateTime dueDate, double totalHours, double frequency){

        long diff = ChronoUnit.DAYS.between(startDate, dueDate);  //Get the number of days between startDate and dueDate

        double slots = diff*(frequency/7); //Calculate the number of slots needed to work on the task base on user input frequency;

        double idealChunk = totalHours/slots; //Get the ideal number of slots needed to complete the task

        return Math.max(idealChunk, 0.5); //Ideal chunk for each slot
    }

    /** Finds whether the given chunk of time is available in all the days in the given week
     *
     * @param week: The week that is checked to see if the idealChunk is able to fit into each day
     * @param idealChunk: The ideal chunk of time that a user must work on a project per day
     * @return true if the idealChunk is less than or equal to the maximum free timeslot of all the days in the week.
     * If there is at least one day that does not have enough time, then return false
     */
     public static boolean fitSchedule(Week week, double idealChunk){

        for(Day day: week.getDays()){ //Check if each day has enough time for idealChunk

            double maxDay = calculateMaxHoursDay(day); //get the maximum free timeslot fpr each day in the week

            //if the maximum free timeslot for each day is less than the idealChunk
            //return false, else return true.
            if (maxDay < idealChunk) {
                return false;}
        }
        return true;
    }

    /** Finds the maximum number of hours that are available in all days of the given week
     *
     * @param week: The week that is being checked to see the max timeslots that are available for all days
     * @return the maximum hours that are available for all days in the given week
     */
     public static double calculateMaxHoursWeek(Week week) {

        double maxHour = 0.0; //set variable maxHour

        for(Day day: week.getDays()){  //iterate through each day in the week to find the maximum free timeslot of the week

            double maxDay = calculateMaxHoursDay(day); //find the maximum free timeslot of each day in a week, assign it to variable maxDay

            if(maxHour < maxDay){
                maxHour = maxDay;
            } //if the maximum timeslot of the day is greater than maxHour, replace maxHour with maxDay
        }
        return maxHour;
    }


    /** Calculates the maximum number of hours that are available in the given day
     *
     * @param day: The day that the max number of free timeslots are being found in
     * @return the maximum number of hours that are available in the given day
     */
     private static double calculateMaxHoursDay (Day day){

        //set variable maxHour and currentMax
        double maxHour = 0.0;
        double currentMax = 0.0;


        List<String> tasks = new ArrayList<>(day.getTodaySchedule().values()); //create a list of values in todaySchedule

        for (String task : tasks) { //loop through the list

            //if there is no task assigned to this time (empty string)
            //add 0.5 to currentMax
            if (Objects.equals(task, "")) {
                currentMax += 0.5;
                //replace maxHour with currentMax is currentMax > maxHour
                if (currentMax > maxHour) {
                    maxHour = currentMax;
                }
                //if there is task assigned to this time, reset currentMax to 0
            } else {
                currentMax = 0.0;
            }
        }
        return maxHour;
    }
}

