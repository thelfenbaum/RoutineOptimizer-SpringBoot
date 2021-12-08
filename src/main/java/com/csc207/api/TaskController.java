package com.csc207.api;

import com.csc207.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;
    private final TaskSerializableInteractorDataIn taskSerializableInteractorDataIn;
    private WeekSerializableInteractorDataOut weekSerializableInteractorDataOut;

    public TaskController(TaskSerializableInteractorDataOut taskSerializableInteractorDataOut, TaskSerializableInteractorDataIn taskSerializableInteractorDataIn){
        this.taskSerializableInteractorDataOut = taskSerializableInteractorDataOut;
        this.taskSerializableInteractorDataIn = taskSerializableInteractorDataIn;
    }

    @GetMapping("/tasks/{userid}")
    @CrossOrigin
    public List<TaskSerializable> getTasks(@PathVariable String userid){
        return this.taskSerializableInteractorDataOut.getTasksByUserId(Long.valueOf(userid));
    }


    @PostMapping("/tasks")
    @CrossOrigin
    @Transactional
    public void saveTask(TaskSerializable task){
        this.taskSerializableInteractorDataIn.saveTaskSerializable(task);
    }

    @GetMapping("/tasks/instantiate/{name}/{dueDateTime}/{duration}/{userId}")
    @CrossOrigin
    @Transactional
    public void instantiateNonFixedTask(@PathVariable String name, @PathVariable String dueDateTime, @PathVariable String duration, @PathVariable String userId){
        LocalDateTime DueDateTime = LocalDateTime.parse(dueDateTime);
        LocalTime Duration = LocalTime.parse(duration);
        long UserId = Long.parseLong(userId);
        NonFixedTask task = new NonFixedTask(name, DueDateTime, Duration, UserId);
        Week week = importWeek(UserId);
        NonFixedTask taskScheduled = Scheduler.ScheduleTaskInWeek(week, task);
        TaskSerializable taskSer = TasktoTaskSerializableAdaptor.TaskToTaskSerializable(taskScheduled);
        saveTask(taskSer);
    }


    public Week importWeek(long userId) {
        Week week;
        WeekSerializable weekSers = this.weekSerializableInteractorDataOut.getWeekSerializableByUserId(userId);
        this.weekSerializableInteractorDataOut.removeWeekSerializableByUserId(userId);
        ArrayList<TaskSerializable> tasksSers = this.taskSerializableInteractorDataOut.getTasksByUserId(userId);
        this.taskSerializableInteractorDataOut.removeTaskSerializablesByUserId(userId);
        week = SerializableToWeekAdapter.SerializableToWeek(weekSers, tasksSers);
        return week;
    }


    public void instantiateFixedTask(String name, LocalDateTime startDateTime, LocalTime duration,
                                        Long userId){
        FixedTask task = new FixedTask(name, startDateTime, duration, userId);
        Week week = importWeek(userId);
        TaskSerializable taskSer = TasktoTaskSerializableAdaptor.TaskToTaskSerializable(task);
        saveTask(taskSer);
    }


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
            String taskDueDateTime = scheduledTasks[i].dueDateTime.toString();
            String taskDuration = scheduledTasks[i].getDuration().toString();
            instantiateFixedTask(scheduledTasks[0].getName(), scheduledTasks[0].getStartDateTime(),
                    scheduledTasks[0].getDuration(), scheduledTasks[0].getUserId());
        }

    }

}
