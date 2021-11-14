package accessingdatajpa;

import com.csc207.routop.TaskSerializable;
import com.csc207.routop.Week;
import com.csc207.routop.WeekSerializable;

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

    public static ArrayList<TaskSerializable> WeekToTaskSerializable(Week week){}

    public static Week SerializableToWeek(WeekSerializable weekSer, ArrayList<TaskSerializable> taskSers){}
}
