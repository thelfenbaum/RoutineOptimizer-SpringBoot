package com.csc207.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class represents a non-fixed task. A non-fixed task should include the tasks name, due date, duration, and
 * user id of the user that the task belongs to.
 */

public class NonFixedTask extends Task {
    public LocalDateTime dueDateTime;

    /**
     *
     * Construct a NonFixedTask, giving the task its name, due date and duration
     * @param name name of the task
     * @param duration duration of the task
     * @param dueDateTime the date and time when the task is due
     */
    public NonFixedTask(String name, LocalDateTime dueDateTime, LocalTime duration, Long userId){
        super(name, duration, userId);
        this.dueDateTime = dueDateTime;
    }
}
