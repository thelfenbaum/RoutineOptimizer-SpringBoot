package accessingdatajpa;

import com.csc207.routop.TaskSerializable;
import com.csc207.routop.Week;
import com.csc207.routop.WeekSerializable;

import java.util.ArrayList;

public class WeekAndSerializableConverter {
    public static WeekSerializable WeekToWeekSerializable(Week week){}

    public static ArrayList<TaskSerializable> WeekToTaskSerializable(Week week){}

    public static Week SerializableToWeek(WeekSerializable weekSer, ArrayList<TaskSerializable> taskSers){}
}
