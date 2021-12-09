package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

/**
 * This class is responsible for inputting all the TaskSerializable objects into the database.
 */

@Configuration
public class TaskSerializableInteractorDataIn {
    @Autowired
    private final TaskSerializableRepository taskSerRepo;

    /**
     * Constructor for the TaskSerializableInteractorDataIn.
     * @param taskSerRepo: The database to store all the TaskSerializable objects.
     */
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
