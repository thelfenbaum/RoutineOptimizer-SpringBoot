package com.csc207.domain;

import java.util.ArrayList;

public class WeekToSerializableAdapter {

    /**
     * Convert a Week to a WeekSerializable to be saved to a database.
     *
     * @param week: the Week to be converted to a WeekSerializable
     * @return the WeekSerializable corresponding to this Week.
     */
    public static WeekSerializable WeekToWeekSerializable(Week week){
        return new WeekSerializable(week.getDays()[0].getDayOfMonth(), week.getUserId());
    }

    /**
     * Convert a Week to an array of TaskSerializables
     *
     * @param week: the Week to be converted to a TaskSerializable.
     * @return an Array of TaskSerializables corresponding to this Week.
     */
    public static ArrayList<TaskSerializable> WeekToTaskSerializable(Week week){
        ArrayList<TaskSerializable> taskSers = new ArrayList<>();
        for(Day day: week.getDays()){
            for(Task task: day.getTodayTasks()){
                taskSers.add(new TaskSerializable(task.getName(), task.getStartDateTime(), task.getDuration(), task.isCompleted(), task.getUserId()));
            }
        }
        return taskSers;
    }

}
