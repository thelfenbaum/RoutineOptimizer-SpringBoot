package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Configuration
public class TaskSerializableInteractorDataIn {
    @Autowired
    private final TaskSerializableRepository taskSerRepo;

    public TaskSerializableInteractorDataIn(TaskSerializableRepository taskSerRepo){
        this.taskSerRepo = taskSerRepo;
    }

    /**
     * Saves a taskSerializable to the database.
     *
     * @param taskSer: the taskSerializable.
     */
    @Transactional
    public void saveTaskSerializable(TaskSerializable taskSer){
        this.taskSerRepo.save(taskSer);
    }


}
