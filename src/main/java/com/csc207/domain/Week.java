package com.csc207.domain;

/**
 * This class represents a week. The Week object should include the user id of the week and the days of the week.
 */

public class Week {
    private Long userId;
    private Day[] days;

    protected Week(){}
    /**
     *
     * Construct a week, giving the week its start date and an array of days in that week.
     * Class Week contains seven days. It represents a user's week and contains the data regarding all of their tasks.
     *
     * @param days: a list of seven consecutive days.
     * @param userId: the id of the user constructing this Week object.
     */
    public Week(Long userId, Day[] days){
        this.userId = userId;
        this.days = days;
    }


    /**
     * Return the string representation of a week that lists the start date of the week and the
     * information of each day within the week (each day has a string representation of
     * its day of week and schedule)
     */

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Week starting on ").append(this.days[0].getDayOfWeek()).append(", ").append(this.days[0].getDayOfMonth()).append("\n");
        string.append("-------------------------------------------\n");
        for(Day day: this.days){
            string.append(day.toString());
        }
        return string.toString();
    }

    /**
     * Gets the days.
     * @return The days of the week.
     */
    public Day[] getDays() {
        return days;
    }

    /**
     * Gets the user id.
     * @return The user id of the week.
     */
    public Long getUserId() {
        return userId;
    }
}
