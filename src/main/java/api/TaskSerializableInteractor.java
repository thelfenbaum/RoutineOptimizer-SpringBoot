package api;

import entities.TaskSerializable;

import java.util.ArrayList;

public class TaskSerializableInteractor {
    private TaskSerializableRepository taskSerRepo;

    public TaskSerializableInteractor(TaskSerializableRepository taskSerRepo){
        this.taskSerRepo = taskSerRepo;
    }

    /** Returns a list of tasks associated with a user.
     *
     * @param userId: the id of the user.
     */
    public ArrayList<TaskSerializable> getTasksByUserId(long userId) {
        return this.taskSerRepo.getTasksByUserId(userId);
    }
}
