package com.csc207.domain;

import java.time.LocalDateTime;

public class CreateProjectRequest {
    private long userid;
    private String name;
    private double maxHoursPerTask;
    private LocalDateTime dueDateTime;
    private LocalDateTime startDateTime;

    public CreateProjectRequest(long userid, String name, double maxHoursPerTask, LocalDateTime dueDateTime, LocalDateTime startDateTime){
        this.userid = userid;
        this.name = name;
        this.maxHoursPerTask = maxHoursPerTask;
        this.dueDateTime = dueDateTime;
        this.startDateTime = startDateTime;
    }

    public long getUserid() {
        return userid;
    }

    public double getMaxHoursPerTask() {
        return maxHoursPerTask;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
}
