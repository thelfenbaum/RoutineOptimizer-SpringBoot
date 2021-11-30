package com.csc207.cli;

import com.csc207.domain.*;

public class Controller {

    /**
     * Initiates scheduling and putting of a fixed task if user chooses
     * to add one to their schedule in UI.
     * @param week: the week to schedule into
     * @param taskToPut: the task to schedule
     */
    public static void activateFixedTaskScheduling(Week week, FixedTask taskToPut){
        Putter.putTask(week, taskToPut);
    }

    /**
     * Initiates scheduling and putting of a non-fixed task if user chooses
     * to add one to their schedule in UI.
     * @param week: the week to schedule into
     * @param taskToSchedule: the task to schedule
     */
    public static void activateNonFixedTaskScheduling(Week week, NonFixedTask taskToSchedule){
        NonFixedTask NonFixedTaskToPut = Scheduler.ScheduleTaskInWeek(week, taskToSchedule);
        Putter.putTask(week, NonFixedTaskToPut);
    }

    /**
     * Initiate scheduling and putting of project based on user preferences
     * @param week: the week to schedule into
     * @param projectTasksToSchedule: the list of tasks to schedule
     */
    public static void activateProjectScheduling(Week week, NonFixedTask[] projectTasksToSchedule){
        NonFixedTask[] projectTasksToPut = Scheduler.ScheduleProject(week, projectTasksToSchedule);
        Putter.putProject(projectTasksToPut[0].getName(), week, projectTasksToPut);
    }

    /**
     * Check if a non-fixed task can be scheduled
     * @param week: the week to schedule into
     * @param taskToSchedule: the task to check
     */
    public static boolean checkNonFixedTaskScheduling(Week week,NonFixedTask taskToSchedule){
        return Checker.CheckScheduleNonFixedTask(week, taskToSchedule);
    }

    /**
     * Check if a project task can be scheduled
     * @param week: the week to schedule into
     * @param projectToSchedule: the project check
     */
    public static boolean checkProjectScheduling(Week week,NonFixedTask[] projectToSchedule){
        return Checker.CheckScheduleProject(week, projectToSchedule);
    }

    /**
     * Check if a fixed task can be scheduled
     * @param week: the week to schedule into
     * @param taskToSchedule: the task to check
     */
    public static boolean checkFixedTaskScheduling(Week week,FixedTask taskToSchedule){
        return Checker.CheckScheduleFixedTask(week, taskToSchedule);
    }

}
