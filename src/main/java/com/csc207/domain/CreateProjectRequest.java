package com.csc207.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class is responsible for creating a request to create a project
 */
public class CreateProjectRequest {
    private final long userid;
    private final String name;
    private final LocalTime maxHoursPerTask;
    private final LocalDateTime dueDateTime;
    private final LocalDateTime startDateTime;

    /**
     * The constructor for this class.
     * @param userid: The user id.
     * @param name: The name of the task.
     * @param maxHoursPerTask: The max number of hours per task.
     * @param dueDateTime: The due date and time.
     * @param startDateTime: The start date and time.
     */
    public CreateProjectRequest(long userid, String name, LocalTime maxHoursPerTask, LocalDateTime dueDateTime, LocalDateTime startDateTime){
        this.userid = userid;
        this.name = name;
        this.maxHoursPerTask = maxHoursPerTask;
        this.dueDateTime = dueDateTime;
        this.startDateTime = startDateTime;
    }

    /**
     * Gets the user id of the project.
     * @return the user id.
     */
    public long getUserid() {
        return userid;
    }

    /**
     * Gets the max hours per task.
     * @return the max hours
     */
    public LocalTime getMaxHoursPerTask() {
        return maxHoursPerTask;
    }

    /**
     * Gets the name of the project.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the due date and time of the project.
     * @return The due date and time.
     */
    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    /**
     * Gets the start date and time of the project.
     * @return The start date and time.
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
}
