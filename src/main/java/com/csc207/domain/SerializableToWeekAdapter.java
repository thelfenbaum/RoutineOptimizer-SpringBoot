package com.csc207.domain;

import java.util.ArrayList;

/**
 * This class is responsible for converting WeekSerializable objects and TaskSerializable objects into a Week object.
 */

public class SerializableToWeekAdapter {
    /**
     * Convert a WeekSerializable and an Array of TaskSerializable into a Week.
     *
     * @param weekSer: the WeekSerializable.
     * @param taskSers: the TaskSerializable.
     * @return the resultant Week.
     */
    public static Week SerializableToWeek(WeekSerializable weekSer, ArrayList<TaskSerializable> taskSers){
        // convert all TaskSerializable to Tasks
        ArrayList<Task> tasks = new ArrayList<>();
        for(TaskSerializable taskSer: taskSers){
            tasks.add(TaskSerializableToTask(taskSer));
        }
        // create a Week object
        Day[] days = DaysInjector.constructDayList(weekSer.startDate);
        Week week = new Week(weekSer.userId, days);
        // schedule all Tasks from tasks onto there
        for(Task task: tasks){
            Putter.putTask(week, task);
        }
        return week;
    }

    /**
     * Helper method which converts a TaskSerializable to a Task.
     *
     * @param taskSer: the TaskSerializable.
     * @return the resultant Task.
     */
    private static Task TaskSerializableToTask(TaskSerializable taskSer){
        return new Task(taskSer.getName(), taskSer.getStartDateTime(), taskSer.getDuration(), taskSer.getUserId());
    }
}
