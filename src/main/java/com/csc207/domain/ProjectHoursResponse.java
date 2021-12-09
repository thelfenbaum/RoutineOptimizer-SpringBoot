package com.csc207.domain;

/**
 * This class is responsible for getting the minimum and maximum number of hours for a project.
 */

public class ProjectHoursResponse {
    private double minHours;
    private double maxHours;

    /**
     * The constructor for a ProjectHoursResponse object.
     * @param minHours: The maximum number of hours to work on a project.
     * @param maxHours: The minimum number of hours to work on a project.
     */
    public ProjectHoursResponse(double minHours, double maxHours){
        this.minHours = minHours;
        this.maxHours = maxHours;
    }

    /**
     * Gets the minimum number of hours to work on a project.
     * @return the minimum number of hours.
     */
    public double getMinHours() {
        return minHours;
    }

    /**
     * Gets the maximum number of hours to work on a project.
     * @return the maximum number of hours.
     */
    public double getMaxHours() {
        return maxHours;
    }

}
