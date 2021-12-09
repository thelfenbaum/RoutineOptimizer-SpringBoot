package com.csc207.api;

import com.csc207.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for interactions between Tasks and the database.
 */

@RestController
public class TaskController {
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;
    private final TaskSerializableInteractorDataIn taskSerializableInteractorDataIn;
    private final WeekSerializableInteractorDataOut weekSerializableInteractorDataOut;

    /**
     * The constructor for this class.
     * @param taskSerializableInteractorDataOut: The TaskSerializable interactor to get tasks from the database.
     * @param taskSerializableInteractorDataIn: The TaskSerializable interactor to save tasks to the database.
     */
    public TaskController(TaskSerializableInteractorDataOut taskSerializableInteractorDataOut, TaskSerializableInteractorDataIn taskSerializableInteractorDataIn){
    WeekSerializableInteractorDataOut weekSerializableInteractorDataOut){
        this.taskSerializableInteractorDataOut = taskSerializableInteractorDataOut;
        this.taskSerializableInteractorDataIn = taskSerializableInteractorDataIn;
        this.weekSerializableInteractorDataOut = weekSerializableInteractorDataOut;
    }

    /**
     * Get all tasks from the database associated with the given userid.
     * @param userid: the user id.
     * @return A list of tasks associated with a user.
     */
    @GetMapping("/tasks/{userid}")
    @CrossOrigin
    public List<TaskSerializable> getTasks(@PathVariable String userid){
        return this.taskSerializableInteractorDataOut.getTasksByUserId(Long.valueOf(userid));
    }

    /**
     * Saves a task to the database.
     * @param task: The task to be saved.
     */
    @PostMapping("/tasks")
    @CrossOrigin
    @Transactional
    public void saveTask(@RequestBody TaskSerializable task){
        this.taskSerializableInteractorDataIn.saveTaskSerializable(task);
    }

    /**
     * Creates a NonFixedTask object and saves it to the database.
     * @param name: The name of the task.
     * @param dueDateTimeStr: The due date of the task.
     * @param durationStr: The duration of the task.
     * @param userId: The user id.
     */
    @PostMapping("/tasks/instantiate/{name}/{dueDateTimeStr}/{durationStr}/{userId}")
    @CrossOrigin
    @Transactional
    public void instantiateNonFixedTask(@PathVariable String name, @PathVariable String dueDateTimeStr, @PathVariable String durationStr, @PathVariable String userId){
        LocalDateTime dueDateTime = StringToDateTime.stringToLocalDateTime(dueDateTimeStr);
        LocalTime Duration = StringToDateTime.stringToLocalTime(durationStr);
        long UserId = Long.parseLong(userId);
        NonFixedTask task = new NonFixedTask(name, dueDateTime, Duration, UserId);
        Week week = importWeek(UserId);
        NonFixedTask taskScheduled = Scheduler.ScheduleTaskInWeek(week, task);
        TaskSerializable taskSer = TasktoTaskSerializableAdaptor.TaskToTaskSerializable(taskScheduled);
        saveTask(taskSer);
    }


    /**
     * Imports a week from the database of a given userid.
     * @param userId: the user id
     * @return: the week of the userid
     */
    public Week importWeek(long userId) {
        Week week;
        WeekSerializable weekSers = this.weekSerializableInteractorDataOut.getWeekSerializableByUserId(userId);
//        this.weekSerializableInteractorDataOut.removeWeekSerializableByUserId(userId);
        ArrayList<TaskSerializable> tasksSers = this.taskSerializableInteractorDataOut.getTasksByUserId(userId);
        this.taskSerializableInteractorDataOut.removeTaskSerializablesByUserId(userId);
        week = SerializableToWeekAdapter.SerializableToWeek(weekSers, tasksSers);
        return week;
    }

    /**
     * Creates a FixedTask object and saves it to the database.
     * @param name: The name of the task.
     * @param startDateTime: The start date and time of the task.
     * @param duration: The duration of the task.
     * @param userId: The user id.
     */
    public void instantiateFixedTask(String name, LocalDateTime startDateTime, LocalTime duration,
                                        Long userId){
        FixedTask task = new FixedTask(name, startDateTime, duration, userId);
        TaskSerializable taskSer = TasktoTaskSerializableAdaptor.TaskToTaskSerializable(task);
        saveTask(taskSer);
    }


    /**
     * Creates a scheduled project.
     * @param name: The name of the task.
     * @param dueDateTime: The date and time the task is due.
     * @param maxHoursPerTask: The maximum hours per task
     * @param userId: The user id.
     */
    @GetMapping("/tasks/project/{name}/{dueDateTime}/{maxHoursPerTask}/{userId}")
    @CrossOrigin
    @Transactional
    public void createScheduledProject (@PathVariable String name, @PathVariable String dueDateTime,
                                       @PathVariable Double maxHoursPerTask, @PathVariable String userId){

        NonFixedTask[] projectTasks = new NonFixedTask[7];
        LocalDateTime DueDateTime = LocalDateTime.parse(dueDateTime);
        LocalTime Duration =  ConvertTimeAndDouble.ConvertDoubleToLocalTime(maxHoursPerTask);
        long UserId = Long.parseLong(userId);
        for (int i = 0; i < 7; i++) {
            projectTasks[i] = new NonFixedTask(name, DueDateTime, Duration, UserId);
        }
        Week week = importWeek(UserId);
        NonFixedTask[] scheduledTasks = Scheduler.ScheduleProject(week, projectTasks);
        int i;
        for (i = 0; i < scheduledTasks.length; i++){
            instantiateFixedTask(scheduledTasks[0].getName(), scheduledTasks[0].getStartDateTime(),
                    scheduledTasks[0].getDuration(), scheduledTasks[0].getUserId());
        }

    }

}
