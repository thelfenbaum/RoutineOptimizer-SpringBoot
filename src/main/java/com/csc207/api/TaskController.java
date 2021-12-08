package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;
    private final TaskSerializableInteractorDataIn taskSerializableInteractorDataIn;

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
}
