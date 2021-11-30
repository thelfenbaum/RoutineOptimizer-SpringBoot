package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import com.csc207.domain.Week;
import com.csc207.domain.WeekToSerializableAdapter;
import com.csc207.domain.WeekSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RestController
public class WeekController {
    @Autowired
    private final WeekSerializableInteractorDataOut weekSerializableInteractor;
    @Autowired
    private final TaskSerializableInteractorDataIn taskSerializableInteractor;

    public WeekController(WeekSerializableInteractorDataOut weekSerializableInteractor,
                          TaskSerializableInteractorDataIn taskSerializableInteractor) {
        this.weekSerializableInteractor = weekSerializableInteractor;
        this.taskSerializableInteractor = taskSerializableInteractor;
    }

    @Transactional
    public void saveWeek(Week week) {
        // convert to week serializable
        WeekSerializable convertedWeek = WeekToSerializableAdapter.WeekToWeekSerializable(week);
        // convert to task serializable
        ArrayList<TaskSerializable> convertedTasks = WeekToSerializableAdapter.WeekToTaskSerializable(week);
        // save weekSerializable
        this.weekSerializableInteractor.saveWeekSerializable(convertedWeek);
        // save taskSerializable
        for(TaskSerializable task: convertedTasks) {
            this.taskSerializableInteractor.saveTaskSerializable(task);
        }
    }
}
