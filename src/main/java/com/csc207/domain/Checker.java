package com.csc207.domain;

import java.time.LocalDateTime;


public class Checker {

    /**
     * Take a Week and a list of NonFixedTask to find whether the project (list of NonFixedTasks) can be
     * scheduled in the given week.
     *
     * @param week: the Week to schedule the task into.
     * @param projectTask: the project to be scheduled.
     * @return true if the project can be scheduled, false otherwise.
     */
    public static boolean CheckScheduleProject(Week week, NonFixedTask[] projectTask){
        Task[] checkScheduleProject = Scheduler.ScheduleProject(week, projectTask);
        LocalDateTime defaultValue = LocalDateTime.of(0, 1, 1, 0, 0);
        for (Task task : checkScheduleProject) {
            if (task.getStartDateTime().equals(defaultValue)) { // check if the task has been scheduled
                return false;
            }
        }
        return true;
    }

    /**
     * Take a Week and a NonFixedTask to find whether the NonFixedTask can be
     * scheduled in the given week.
     *
     * @param week: the Week to schedule the task into.
     * @param task: the nonFixedTask to be scheduled.
     * @return true if the nonFixedTask can be scheduled, return false otherwise.
     */

    public static boolean CheckScheduleNonFixedTask(Week week, NonFixedTask task){
        Task checkScheduleProject = Scheduler.ScheduleTaskInWeek(week, task);
        LocalDateTime defaultValue = LocalDateTime.of(0, 1, 1, 0, 0);
        return !checkScheduleProject.getStartDateTime().equals(defaultValue);
    }

    /**
     * Take a Week and a FixedTask to find whether the FixedTask can be
     * scheduled in the given week.
     *
     * @param week: the Week to schedule the task into.
     * @param task: the FixedTask to be scheduled.
     * @return true if the FixedTask can be scheduled, return false otherwise.
     */

    public static boolean CheckScheduleFixedTask(Week week, FixedTask task) {
        for (Day day: week.getDays()){
            if (task.getStartDateTime().toLocalDate().equals(day.getDayOfMonth())){ // check if this day is the same as the day for the tasl
                double startTimeD = ConvertTimeAndDouble.ConvertDateTimeDouble(task.getStartDateTime());
                if(!day.getTodaySchedule().get(startTimeD).equals("")){
                    return false;
                }
            }
        }
        return true;

    }

}

