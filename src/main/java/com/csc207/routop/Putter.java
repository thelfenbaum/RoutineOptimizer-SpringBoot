package com.csc207.routop;

import java.time.LocalDateTime;

public class Putter {

    /**
     * Puts a task into a week. Loops through a week to find the day that we want to schedule the task and
     * adds the task to that day's schedule.
     * (see README for why the word "put" is used here).
     * The reason we schedule one half hour of a task at a time is twofold: (1) this.todaySchedule comprises
     * distinct half-hour intervals, and (2) if a task crosses over multiple days,
     * different half-hours will need to be scheduled onto different days.
     */

    public static void putTask(Week week, Task task){
        // loop through half-hours and put them into the correct day using Day.putHalfHourTask.
        LocalDateTime taskStart = task.getStartDateTime();
        for (Day day: week.getDays()) {
            // find the day this task starts in this week
            if (taskStart.toLocalDate().isEqual(day.getDayOfMonth())) {
                //convert task duration to double
                int hour = task.getDuration().getHour();
                int minute = task.getDuration().getMinute();
                double minuteDouble = ((double)minute/60);
                //calculate the number of half hour block represented by the minute
                double minuteBlock = minuteDouble/0.5;
                //calculate total number of half hour blocks in the task duration
                int totalTaskBlock = hour*2 + (int) minuteBlock;
                //convert the start time of task to double
                double h = task.getStartDateTime().getHour();
                double m = (double)(task.getStartDateTime().getMinute())/60;
                double startTimeD = h + m;
                //loop through todaySchedule and mutate the value of the corresponding key
                int i = 0;
                while (i < totalTaskBlock) {
                    day.getTodaySchedule().replace(startTimeD + 0.5*i, task.getName());
                    i ++;
                }
            }
        }
    }



    /**
     * Puts a project into a week. A project is an array of non-fixed task.
     * Loops through a week to find the day that we want to schedule each non-fixed task and
     * adds the task to that day's schedule.
     * (see README for why the word "put" is used here).
     */

    public static void putProject(String projectName, Week week, NonFixedTask[] tasks){
        for (NonFixedTask task : tasks) {
            task.name = projectName;
            putTask(week, task);
        }

    }
}
