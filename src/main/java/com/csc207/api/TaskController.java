package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;

    public TaskController(TaskSerializableInteractorDataOut taskSerializableInteractorDataOut){
        this.taskSerializableInteractorDataOut = taskSerializableInteractorDataOut;
    }

    @GetMapping("/tasks/{userid}")
    @CrossOrigin
    public List<TaskSerializable> getTasks(@PathVariable String userid){
        return this.taskSerializableInteractorDataOut.getTasksByUserId(Long.valueOf(userid));
    }
}
