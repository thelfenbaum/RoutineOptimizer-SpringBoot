package accessingdatajpa;

import com.csc207.routop.Task;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TaskInteractor {


    /**
     * Get all tasks on the week starting on this date from the database.
     *
     * @param weekStartDate: the start date of the week in which we are searching
     *                    for tasks.
     * @param userId: the ID of the user accessing tasks in the database.
     */
    public ArrayList<Task> getTaskByWeek(LocalDate weekStartDate, int userId){
        ArrayList<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i <= 6; i++){
            LocalDate date = weekStartDate.plusDays(i);
            ArrayList<Task> todayTasks = getTaskByDate(date, userId);
            tasks.addAll(todayTasks);
        }
        return tasks;
    }
}
