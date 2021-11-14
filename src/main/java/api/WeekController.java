package api;

import entities.TaskSerializable;
import entities.Week;
import entities.WeekSerializable;

import java.util.ArrayList;

public class WeekController {
    public WeekSerializableInteractor weekSerializableInteractor;
    public TaskSerializableInteractor taskSerializableInteractor;
    public WeekController(WeekSerializableInteractor weekSerializableInteractor,
                          TaskSerializableInteractor taskSerializableInteractor) {
        this.weekSerializableInteractor = weekSerializableInteractor;
        this.taskSerializableInteractor = taskSerializableInteractor;
    }
    public void saveWeek(Week week) {
        // convert to week serializable
        WeekSerializable convertedWeek = WeekAndSerializableConverter.WeekToWeekSerializable(week);
        // convert to task serializable
        ArrayList<TaskSerializable> convertedTasks = WeekAndSerializableConverter.WeekToTaskSerializable(week);
        // save weekSerializable
        this.weekSerializableInteractor.saveWeekSerializable(convertedWeek);
        // save taskSerializable
        for(TaskSerializable task: convertedTasks) {
            this.taskSerializableInteractor.saveTaskSerializable(task);
        }
    }
}
