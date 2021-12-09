package com.csc207.domain;

public class ProjectHoursResponse {
    private final double minHours;
    private final double maxHours;

    public ProjectHoursResponse(double minHours, double maxHours){
        this.minHours = minHours;
        this.maxHours = maxHours;
    }

    public double getMinHours() {
        return minHours;
    }

    public double getMaxHours() {
        return maxHours;
    }

}
