package accessingdatajpa;

import com.csc207.routop.ConvertTimeToDouble;
import com.csc207.routop.Task;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TaskInteractor {
    public TaskRepository taskRepo;

    public TaskInteractor(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    /**
     * Get all tasks on the week starting on this date from the database.
     *
     * @param weekStartDate: the start date of the week in which we are searching
     *                    for tasks.
     * @param userId: the ID of the user accessing tasks in the database.
     */
    public ArrayList<Task> getTaskByWeek(LocalDate weekStartDate, double userId){
        ArrayList<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i <= 6; i++){
            LocalDate date = weekStartDate.plusDays(i);
            ArrayList<Task> todayTasks = this.taskRepo.getTaskByDate(date, userId);
            tasks.addAll(todayTasks);
        }
        return tasks;
    }

    public String getDayString(LocalDate date, double userId){
        StringBuilder s = new StringBuilder();
        LinkedHashMap<Double, String> scheduleString = new LinkedHashMap<Double, String>();
        for(double i = 0.0; i <= 23.5; i = i + 0.5){
            scheduleString.put(i, "");
        }
        s.append("------ ").append(date.getDayOfWeek()).append(" ------\n");
        for(Task task: this.taskRepo.getTaskByDate(date, userId)){
            int hour = task.duration.getHour();
            int minute = task.duration.getMinute();
            double minuteDouble = ((double)minute/60);
            double minuteBlock = minuteDouble/0.5;
            int totalTaskBlock = hour*2 + (int) minuteBlock;
            double startTimeD = ConvertTimeToDouble.ConvertLocalTimeDouble(task.startDateTime.toLocalTime());
            int i = 0;
            while (i < totalTaskBlock) {
                scheduleString.replace(startTimeD + 0.5*i, task.name);
                i ++;
            }
        }
        for(Double time: scheduleString.keySet()){
            s.append(time).append(": ").append(scheduleString.get(time)).append("\n");
        }
        return s.toString();
    }

    /**
     * Get the String representation of the Week starting on <weekStartDate> associated with user
     * <userID>.
     * @param weekStartDate: the LocalDate this week starts on.
     * @param userId: the user's user ID.
     * @return the string representation of the Week object we are looking up in the database.
     */
    public String getWeekString(LocalDate weekStartDate, double userId){
        StringBuilder s = new StringBuilder();
        s.append("Week starting on ").append(weekStartDate.getDayOfWeek()).append(", ").append(weekStartDate.getDayOfMonth()).append("\n");
        s.append("-------------------------------------------\n");
        for(int i = 0; i <= 6; i++){
            LocalDate currDate = weekStartDate.plusDays(i);
            s.append(getDayString(currDate, userId));
        }
        return s.toString();
    }
}
