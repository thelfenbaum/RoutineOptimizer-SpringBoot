package com.csc207.domain;

public class ProjectHoursResponse {
    private double minHours;
    private double maxHours;

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
