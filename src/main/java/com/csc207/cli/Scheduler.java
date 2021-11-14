package com.csc207.cli;//import java.time.LocalDate;
import entities.Day;
import entities.NonFixedTask;
import entities.Task;
import entities.Week;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

public class Scheduler {

    /**
     * Take a NonFixedTask and find the best (first available) time slot for it in the week.
     * Set that task's start time and duration to this best time slot and return it.
     *
     * Time slots do *not* include overlaps between days.
     * @param week: the Week to schedule the task into.
     * @param task: the Task to be scheduled.
     * @return the task with its updated time slot.
     */
    //added scheduleTaskInWeek for NonFixedTask, should we create a method for splitting project into multiple
    //non-fixed tasks? - Hailey
    public static NonFixedTask ScheduleTaskInWeek(Week week, NonFixedTask task){
//         algorithm to find best time slot in this week
        for (Day day: week.getDays()){
            NonFixedTask dayTask = (NonFixedTask) ScheduleTaskInDay(day, task);
            LocalDateTime defaultValue = LocalDateTime.of(0, 1, 1, 0, 0);
            if(!(dayTask.getStartDateTime().equals(defaultValue))) {
                return dayTask;
            }
         }
        return task;
    }

    /*
      Take a NonFixedTask and find the best (first available) time slot for it in a day.
      Set that task's start time and duration to this best time slot and return it.

      @param day: the Week to schedule the task into.
     * @param task: the Task to be scheduled.
     * @return the task with its updated time slot.
     */

//    public static Task ScheduleTaskInDay(Day day, Task task){
//         algorithm to find best time slot in this day, to be used by ScheduleProject
//        List<Double> time = new ArrayList<Double>();
//        double freeDuration = 0.0;
//        for (double key : day.todaySchedule.keySet()) {
//            String value = day.todaySchedule.get(key);
//            if (value.equals("")){freeDuration += 0.5;
//            if (freeDuration == task.duration)
//            {
//                double startTime = key + 0.5 - task.duration;
//                String startTimeString = Double.toString(startTime);
//                int hourStart = Integer.parseInt(startTimeString.substring(0, 2));
//                int minuteStart = Integer.parseInt(startTimeString.substring(3, 5));
//                LocalTime start = LocalTime.of(hourStart, minuteStart);
//                task.startDateTime = LocalDateTime.of(day.dayOfMonth, start);
//            }}
//            else{freeDuration = 0.0;}}
//        return task;
//        }


        /**
         * Take an array of NonFixedTasks with placeholder time slots and find the best (first available)
         * time slot for each one in the given frequency, which is in times per week (FOR PHASE 0, ASSUME THIS IS 7).
         * Set each of these task's start time and duration to this best time slot and return the same array with
         * all the updated tasks.
         *
         * week: the Week to schedule the tasks into.
         * projectTasks: the Tasks to be scheduled.
         * @return the task with its updated time slot.
         */

    public static NonFixedTask[] ScheduleProject(Week week, NonFixedTask[] projectTasks){
        NonFixedTask[] updatedTasks = new NonFixedTask[projectTasks.length];
        for (int i = 0; i < projectTasks.length; i++){
            updatedTasks[i] = (NonFixedTask) ScheduleTaskInDay(week.getDays()[i], projectTasks[i]);
        }
        return updatedTasks;
    }

    /** Takes a task and finds the best(first available) time slot in the given day and sets the task's start time and
     * duration to the best time slot and return the updated task
     *
     * @param day: The day to schedule the task into
     * @param task: the task to be scheduled
     * @return the updated task with the new start time and duration
     */
    public static Task ScheduleTaskInDay (Day day, Task task){
        List<Double> time = new ArrayList<>();
        double freeDuration = 0.0;
        double durationD = ConvertBetweenTimeAndDouble.ConvertLocalTimeDouble(task.getDuration());
        //add all free time to a list
        for (double key : day.getTodaySchedule().keySet()) {
            String value = day.getTodaySchedule().get(key);
            if (value.equals("")){time.add(key);}}
        //iterate through free time to calculate how much free time we have in a row
        for (int i = 0; i < time.size(); i++) {
            if((time.get(i + 1) - time.get(i)) == 0.5){
                freeDuration += 0.5;
                //check if current free duration equals to task duration
                if(freeDuration >= durationD){
                    //if yes, schedule the task to the start of the free duration
                    double startTime = time.get(i+1) - freeDuration;
                    LocalTime start = ConvertBetweenTimeAndDouble.ConvertDoubleToLocalTime(startTime);
                    task.changeStartDateTime(LocalDateTime.of(day.getDayOfMonth(), start));
                    return task;
                    //if duration is not task duration, reset freeDuration to 0.0
                }
            } else{ freeDuration = 0.0;}
    }return task;}


}