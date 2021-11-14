package api;

import entities.TaskSerializable;

import java.util.ArrayList;

public class TaskSerializableInteractor {
    private final TaskSerializableRepository taskSerRepo;

    public TaskSerializableInteractor(TaskSerializableRepository taskSerRepo){
        this.taskSerRepo = taskSerRepo;
    }

    public void saveTaskSerializable(TaskSerializable taskSer){
        this.taskSerRepo.save(taskSer);
    }
    /** Returns a list of tasks associated with a user.
     *
     * @param userId: the id of the user.
     */
    public ArrayList<TaskSerializable> getTasksByUserId(long userId) {
        return this.taskSerRepo.getTasksByUserId(userId);
    }
}
