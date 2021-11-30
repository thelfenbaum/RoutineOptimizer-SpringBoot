package com.csc207.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class FixedTask extends Task {

    /**
     *
     * Construct a FixedTask, giving the task its name, start time and duration
     * @param name name of the task
     * @param duration duration of the task
     * @param startTime start time of the task
     */
    public FixedTask(String name, LocalDateTime startTime,  LocalTime duration, Long userId){
        super(name, startTime, duration, userId);
    }

}
