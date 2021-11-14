package accessingdatajpa;

import com.csc207.routop.*;

import java.util.ArrayList;

public class WeekAndSerializableConverter {

    /**
     * Convert a Week to a WeekSerializable to be saved to a database.
     *
     * @param week: the Week to be converted to a WeekSerializable
     * @return the weekSerializable corresponding to this Week.
     */
    public static WeekSerializable WeekToWeekSerializable(Week week){
        return new WeekSerializable(week.getDays()[0].getDayOfMonth(), week.getUserId());
    }

    public static ArrayList<TaskSerializable> WeekToTaskSerializable(Week week){
        ArrayList<TaskSerializable> taskSers = new ArrayList<TaskSerializable>();
        for(Day day: week.getDays()){
            for(Task task: day.getTodayTasks()){
                taskSers.add(new TaskSerializable(task.getName(), task.getStartDateTime(), task.getDuration(), task.isCompleted(), task.getUserId()));
            }
        }
        return taskSers;
    }

    public static Week SerializableToWeek(WeekSerializable weekSer, ArrayList<TaskSerializable> taskSers){}
}
