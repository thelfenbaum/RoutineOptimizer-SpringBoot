package api;

import entities.TaskSerializable;


import java.util.ArrayList;

public class TaskSerializableInteractor {
    private final TaskSerializableRepository taskSerRepo;

    /**
     * Constructs an interactor for the repo to interact with TaskSerializable.
     * @param taskSerRepo: The TaskSerializableRepository we would like to have tasks interact with.
     */
    public TaskSerializableInteractor(TaskSerializableRepository taskSerRepo){
        this.taskSerRepo = taskSerRepo;
    }

    /**
     * Saves the given TaskSerializable into the TaskSerializableRepository.
     * @param taskSer: The TaskSerializable object we would like to put in the repo.
     */
    public void saveTaskSerializable(TaskSerializable taskSer){
        this.taskSerRepo.save(taskSer);
    }
    /** Returns a list of tasks associated with a user.
     *
     * @param userId: the id of the user.
     * @return The list of tasks of the user.
     */
    public ArrayList<TaskSerializable> getTasksByUserId(long userId) {
        return this.taskSerRepo.getTasksByUserId(userId);
    }
}
