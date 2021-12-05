package com.csc207.api;

import com.csc207.domain.TaskSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * This class is responsible for interacting with the repository and getting data from the TaskSerializable database.
 */

@Configuration
public class TaskSerializableInteractorDataOut {
    @Autowired
    private final TaskSerializableRepository taskSerRepo;

    /**
     * The constructor for the TaskSerializableInteractorDataOut.
     * @param taskSerRepo: The database that the class will interact with.
     */

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

    /** Gets the list of tasks associated with a user.
     *
     * @param userId: the id of the user.
     * @return The list of tasks associated with a user.
     */
    public ArrayList<TaskSerializable> getTasksByUserId(Long userId) {
        return (ArrayList<TaskSerializable>) this.taskSerRepo.getTasksByUserId(userId);
    }

}
