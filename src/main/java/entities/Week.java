package entities;

import entities.Day;

import java.time.LocalDate;

public class Week {
    private Long userId;
    private Day[] days;


    protected Week(){}


    /**
     *
     * Construct a week, giving the week its start date and an array of days in that week.
     * Class Week contains seven days. It represents a user's week and contains the data regarding all of their tasks.
     * @param startDate the start date of that week.
     */
    public Week(LocalDate startDate, Long userId){
        // initialize <days> to an empty array of 7 days
        this.userId = userId;
        this.days = new Day[7];
        // set each element of <days> to its corresponding day, starting with days[0] = new Day(startDate, startDay).
        for(int i = 0; i <= 6; i++){
            days[i] = new Day(startDate.plusDays(i));
        }
    }


    /**
     * Return the string representation of a week that lists the start date of the week and the
     * information of each day within the week (each day has a string representation of
     * its day of week and schedule)
     */

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Week starting on ").append(this.days[0].getDayOfWeek()).append(", ").append(this.days[0].getDayOfMonth()).append("\n");
        s.append("-------------------------------------------\n");
        for(Day day: this.days){
            s.append(day.toString());
        }
        return s.toString();
    }


    public Day[] getDays() {
        return days;
    }

    public Long getUserId() {
        return userId;
    }
}
