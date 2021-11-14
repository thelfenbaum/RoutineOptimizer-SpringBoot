package com.csc207.cli;

import entities.Day;
import entities.Week;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface Project {

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
    static double calculateMinHours(Week week, LocalDate startDate, LocalDateTime dueDate, double totalHours,
                                    double frequency) {
        //return 0.0 if the ideal working time per day does not fit into the user's current schedule, else return
        //idealChunk
        //get the idealChunk
        double idealChunk = getIdealChunk(startDate, dueDate, totalHours, frequency);
        //check if the idealChunk fits in the schedule
        boolean fitSchedule = fitSchedule(week, idealChunk);
        if (fitSchedule) {
            return idealChunk;
        }
        return 0.0;
    }

    /** Finds the ideal chunk of time that a user must work on a project per day and returns the number of hours
     *
     * @param startDate: The day the project will be started on
     * @param dueDate: The day that the project needs to be completed by
     * @param totalHours: The total hours that the project will be worked on
     * @param frequency: the number of times in a week that a project will be worked on
     * @return The ideal chunk of time in hours a user must work on a project per day. If there is no ideal chunk, return 0.5
     */
     static double getIdealChunk(LocalDate startDate, LocalDateTime dueDate, double totalHours, double frequency){
        //Get the number of days between startDate and dueDate
        long diff = ChronoUnit.DAYS.between(startDate, dueDate);
        //Calculate the number of slots needed to work on the task base on user input frequency;
        double slots = diff*(frequency/7);
        //Get the ideal number of slots needed to complete the task
        double idealChunk = totalHours/slots;
        //Ideal chunk for each slot
        return Math.max(idealChunk, 0.5);
    }

    /** Finds whether the given chunk of time is available in all the days in the given week
     *
     * @param week: The week that is checked to see if the idealChunk is able to fit into each day
     * @param idealChunk: The ideal chunk of time that a user must work on a project per day
     * @return true if the idealChunk is less than or equal to the maximum free timeslot of all the days in the week.
     * If there is at least one day that does not have enough time, then return false
     */
     static boolean fitSchedule(Week week, double idealChunk){
        //Check if each day has enough time for idealChunk
        for(Day n: week.days){
            //get the maximum free timeslot fpr each day in the week
            double maxDay = calculateMaxHoursDay(n);
            //if the maximum free timeslot for each day is less than the idealChunk
            //return false, else return true.
            if (maxDay < idealChunk) {
                return false;}}
        return true;
    }

    /** Finds the maximum number of hours that are available in all days of the given week
     *
     * @param week: The week that is being checked to see the max timeslots that are available for all days
     * @return the maximum hours that are available for all days in the given week
     */
     static double calculateMaxHoursWeek(Week week) {
        //set variable maxHour
        double maxHour = 0.0;
        //iterate through each day in the week to find the maximum free timeslot
        //of the week
        for(Day n: week.days){
            //find the maximum free timeslot of each day in a week, assign it to variable maxDay
            double maxDay = calculateMaxHoursDay(n);
            //if the maximum timeslot of the day is greater than maxHour, replace maxHour with maxDay
            if(maxHour < maxDay){maxHour = maxDay;}}
        return maxHour;
    }


    /** Calculates the maximum number of hours that are available in the given day
     *
     * @param day: The day that the max number of free timeslots are being found in
     * @return the maximum number of hours that are available in the given day
     */
     static double calculateMaxHoursDay (Day day){
        //set variable maxHour and currentMax
        double maxHour = 0.0;
        double currentMax = 0.0;
        //create a list of values in todaySchedule
        List<String> task = new ArrayList<>(day.todaySchedule.values());
        //loop through the list
        for (String s : task) {
            //if there is no task assigned to this time (empty string)
            //add 0.5 to currentMax
            if (Objects.equals(s, "")) {
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

