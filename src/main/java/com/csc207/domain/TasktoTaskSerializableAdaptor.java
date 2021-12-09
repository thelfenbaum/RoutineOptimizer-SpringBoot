package com.csc207.domain;

/**
 * This class is responsible for converting the Task to a TaskSerializable object.
 */

public class TasktoTaskSerializableAdaptor {

    /**
     * Convert a Week to a WeekSerializable to be saved to a database.
     *
     * @param task: the task to be converted to a TaskSerializable
     * @return the WeekSerializable corresponding to this Week.
     */

    public static TaskSerializable TaskToTaskSerializable(Task task){
        return new TaskSerializable(task.getName(), task.getStartDateTime(),
                task.getDuration(), task.isCompleted(), task.getUserId());
    }
}
