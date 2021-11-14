package entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private String name;
    private LocalDateTime startDateTime;
    private LocalTime duration;
    private boolean completed;
    private final Long userId;


    /**
     * Constructor to be used by NonFixedTasks, giving the task its name and duration
     *
     * @param name: name of this task
     * @param duration: duration of this task
     */
    public Task(String name, LocalTime duration, Long userId){
        this.name = name;
        this.duration = duration;
        this.startDateTime = LocalDateTime.of(0, 1, 1, 0, 0);
        this.userId = userId;
        this.completed = false;
    }

    /**
     * Constructor to be used by FixedTasks, giving the task its name, start time and duration.
     *
     * @param name: name of this task
     * @param startTime: start date and time of this task
     * @param duration: duration of this task
     */
    public Task(String name, LocalDateTime startTime, LocalTime duration, Long userId){
        this.name = name;
        this.duration = duration;
        this.startDateTime = startTime;
        this.userId = userId;
        this.completed = false;
    }

    /**
     * Completes this task by modifying its 'completed' attribute to true
     */
    public void complete(){
        this.completed = true;
    }

    /**
     * Gets the name of the task
     * @return the name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the id of the task
     * @return the id of the task
     */

    public Long getUserId(){
        return this.userId;
    }

    /**
     * Change the name of the task
     * @param newName: the new name that you would like to rename your task
     */
    public void changeName(String newName) {
        name = newName;
    }

    /**
     * Get the start date and time of the task
     * @return the start date and time of the task
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    /**
     * Gets the duration of the task
     * @return the duration of the task
     */
    public LocalTime getDuration() {
        return duration;
    }

    /**
     * Checks if the task has been completed or not
     * @return whether the task has been completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Changes the start date time of a task, to the given time
     * @param time: The new start day and time of the task
     */
    public void changeStartDateTime(LocalDateTime time) {
        startDateTime = time;
    }

    // want to implement a "schedule" method which takes a task and a time slot and places the task
    // into that time slot.

    // methods for updating task objects:


    /**
     * modify the task's start time
     * @param newStartDateTime: the new start time of the task
     */
    public void changeTaskStartTime (LocalDateTime newStartDateTime) {
        this.startDateTime = newStartDateTime;
    }

    /**
     * modify the task's duration
     * @param newDuration: the new duration of the task
     */
    public void changeTaskDuration(LocalTime newDuration) {
        this.duration = newDuration;
    }

    /**
     *
     */
    public int durationToInt() {
        int hour = this.getDuration().getHour();
        int minute = this.getDuration().getMinute();
        double minuteDouble = ((double)minute/60);
        double minuteBlock = minuteDouble/0.5;
        return hour*2 + (int) minuteBlock;
    }

}



    // want to implement a "schedule" method which takes a task and a time slot and places the task
    // into that time slot.

