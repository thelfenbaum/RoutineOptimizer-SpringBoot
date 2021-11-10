package com.csc207.routop;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class NonFixedTask extends Task {
    public LocalDateTime dueDateTime;

    /**
     *
     * Construct a NonFixedTask, giving the task its name, due date and duration
     * @param name name of the task
     * @param duration duration of the task
     * @param dueDateTime the date and time when the task is due
     */

    public NonFixedTask(String name, LocalDateTime dueDateTime, LocalTime duration){
        super(name, duration);
        this.dueDateTime = dueDateTime;
    }
}
