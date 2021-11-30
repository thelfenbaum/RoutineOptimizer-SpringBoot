package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import com.csc207.domain.Week;
import com.csc207.domain.WeekAndSerializableConverter;
import com.csc207.domain.WeekSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RestController
public class WeekController {
    @Autowired
    private final WeekSerializableInteractor weekSerializableInteractor;
    @Autowired
    private final TaskSerializableInteractor taskSerializableInteractor;

    public WeekController(WeekSerializableInteractor weekSerializableInteractor,
                          TaskSerializableInteractor taskSerializableInteractor) {
        this.weekSerializableInteractor = weekSerializableInteractor;
        this.taskSerializableInteractor = taskSerializableInteractor;
    }

    @Transactional
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
