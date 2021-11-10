package com.csc207.routop;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    public String name;
    public LocalDateTime startDateTime;
    public LocalTime duration;
    public boolean completed;

    /**
     * Constructor to be used by NonFixedTasks, giving the task its name and duration
     *
     * @param name: name of this task
     * @param duration: duration of this task
     */
    public Task(String name, LocalTime duration){
        this.name = name;
        this.duration = duration;
        this.startDateTime = LocalDateTime.of(0, 1, 1, 0, 0);
        completed = false;
    }

    /**
     * Constructor to be used by FixedTasks, giving the task its name, start time and duration.
     *
     * @param name: name of this task
     * @param startTime: start date and time of this task
     * @param duration: duration of this task
     */
    public Task(String name, LocalDateTime startTime, LocalTime duration){
        this.name = name;
        this.duration = duration;
        this.startDateTime = startTime;
        completed = false;
    }

    /**
     * Completes this task by modifying its 'completed' attribute
     */
    public void complete(){
        this.completed = true;
    }

    // want to implement a "schedule" method which takes a task and a time slot and places the task
    // into that time slot.
}
