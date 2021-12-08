package com.csc207.api;

import com.csc207.domain.SerializableToWeekAdapter;
import com.csc207.domain.TaskSerializable;
import com.csc207.domain.Week;
import com.csc207.domain.WeekSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;
    private final TaskSerializableInteractorDataIn taskSerializableInteractorDataIn;
    private WeekSerializableInteractorDataOut weekSerializableInteractorDataOut;

    public TaskController(TaskSerializableInteractorDataOut taskSerializableInteractorDataOut, TaskSerializableInteractorDataIn taskSerializableInteractorDataIn){
        this.taskSerializableInteractorDataOut = taskSerializableInteractorDataOut;
        this.taskSerializableInteractorDataIn = taskSerializableInteractorDataIn;
    }

    @GetMapping("/tasks/{userid}")
    @CrossOrigin
    public List<TaskSerializable> getTasks(@PathVariable String userid){
        return this.taskSerializableInteractorDataOut.getTasksByUserId(Long.valueOf(userid));
    }


    @PostMapping("/tasks")
    @CrossOrigin
    @Transactional
    public void saveTask(TaskSerializable task){
        this.taskSerializableInteractorDataIn.saveTaskSerializable(task);
    }


    public Week importWeek(long userId) {
        Week week;
        WeekSerializable weekSers = this.weekSerializableInteractorDataOut.getWeekSerializableByUserId(userId);
        this.weekSerializableInteractorDataOut.removeWeekSerializableByUserId(userId);
        ArrayList<TaskSerializable> tasksSers = this.taskSerializableInteractorDataOut.getTasksByUserId(userId);
        this.taskSerializableInteractorDataOut.removeTaskSerializablesByUserId(userId);
        week = SerializableToWeekAdapter.SerializableToWeek(weekSers, tasksSers);
        return week;
    }


}
