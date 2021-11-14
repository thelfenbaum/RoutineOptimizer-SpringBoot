package api;

import com.csc207.cli.*;
import entities.*;

import java.util.ArrayList;

public class WeekAndSerializableConverter {

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

    /**
     * Convert a WeekSerializable and an Array of TaskSerializables into a Week.
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
        Week week = new Week(weekSer.startDate, weekSer.userId);
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
