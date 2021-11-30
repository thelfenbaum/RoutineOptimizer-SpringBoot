package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Configuration
public class TaskSerializableInteractorDataOut {
    @Autowired
    private final TaskSerializableRepository taskSerRepo;


    public TaskSerializableInteractorDataOut(TaskSerializableRepository taskSerRepo) {
        this.taskSerRepo = taskSerRepo;
    }

    /**
     * Removes all taskSerializables associated with a user id from the database.
     * @param userId: the user id.
     */
    @Transactional
    public void removeTaskSerializablesByUserId(long userId) {
        ArrayList<Long> listOfIds = new ArrayList<>();
        ArrayList<TaskSerializable> taskSers = getTasksByUserId(userId);
        for(TaskSerializable taskSer: taskSers){
            listOfIds.add(taskSer.getId());
        }
        this.taskSerRepo.deleteAllById(listOfIds);
    }

    /** Returns a list of tasks associated with a user.
     *
     * @param userId: the id of the user.
     */
    public ArrayList<TaskSerializable> getTasksByUserId(Long userId) {
        return (ArrayList<TaskSerializable>) this.taskSerRepo.getTasksByUserId(userId);
    }

}
