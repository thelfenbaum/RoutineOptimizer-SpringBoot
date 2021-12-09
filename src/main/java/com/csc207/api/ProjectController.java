package com.csc207.api;

import com.csc207.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class is responsible for interactions between projects and the database.
 */

@RestController
public class ProjectController {
    @Autowired
    private final WeekSerializableInteractorDataOut weekSerializableInteractorDataOut;
    @Autowired
    private final TaskSerializableInteractorDataOut taskSerializableInteractorDataOut;
    @Autowired
    private final TaskSerializableInteractorDataIn taskSerializableInteractorDataIn;

    /**
     * The constructor for the class.
     * @param weekSerializableInteractorDataOut: The interactor to get weeks from the database.
     * @param taskSerializableInteractorDataOut: The interactor to get tasks from the database.
     */

    public ProjectController(WeekSerializableInteractorDataOut weekSerializableInteractorDataOut,
                             TaskSerializableInteractorDataOut taskSerializableInteractorDataOut,
                             TaskSerializableInteractorDataIn taskSerializableInteractorDataIn){
        this.weekSerializableInteractorDataOut = weekSerializableInteractorDataOut;
        this.taskSerializableInteractorDataOut = taskSerializableInteractorDataOut;
        this.taskSerializableInteractorDataIn = taskSerializableInteractorDataIn;
    }

    /**
     * Calculate the hours of a project.
     * @param userid: The userid.
     * @param totalHoursStr: The total hours.
     * @param startDateStr: The start date.
     * @param dueDateTimeStr: The due date.
     * @return The ProjectHoursResponse object that contains the minimum number of hours and max number of hours.
     */
    @GetMapping("/project/calculatehours/{userid}/{totalHoursStr}/{startDateStr}/{dueDateTimeStr}")
    @CrossOrigin
    public ProjectHoursResponse calculateHours(@PathVariable("userid") String userid,
                              @PathVariable("totalHoursStr") String totalHoursStr,
                              @PathVariable("startDateStr") String startDateStr,
                              @PathVariable("dueDateTimeStr") String dueDateTimeStr) {
        Week week = importWeek(Long.parseLong(userid));
        LocalDate startDate = StringToDateTime.stringToLocalDate(startDateStr);
        LocalDateTime dueDateTime = StringToDateTime.stringToLocalDateTime(dueDateTimeStr);
        int totalHours = Integer.parseInt(totalHoursStr);
        double minHours = CreateProject.calculateMinHours(week, startDate, dueDateTime, totalHours, 7);
        double maxHours = CreateProject.calculateMaxHoursWeek(week);
        return new ProjectHoursResponse(minHours, maxHours);
    }


    /**
     * Import a week of a user.
     * @param userId: The user id.
     * @return The Week of the user
     */
    public Week importWeek(long userId) {
        Week week;
        WeekSerializable weekSers = this.weekSerializableInteractorDataOut.getWeekSerializableByUserId(userId);
        ArrayList<TaskSerializable> tasksSers = this.taskSerializableInteractorDataOut.getTasksByUserId(userId);
        this.taskSerializableInteractorDataOut.removeTaskSerializablesByUserId(userId);
        week = SerializableToWeekAdapter.SerializableToWeek(weekSers, tasksSers);
        return week;
    }

    @PostMapping("project/create-project")
    @CrossOrigin
    public void createProject(@RequestBody CreateProjectRequest createProjectRequest){
        Week week = importWeek(createProjectRequest.getUserid());
        NonFixedTask[] projectTasksToSchedule = new NonFixedTask[7];
        for (int i = 0; i < 7; i++) {
            projectTasksToSchedule[i] = new NonFixedTask(createProjectRequest.getName(), createProjectRequest.getDueDateTime,
                    createProjectRequest.getMaxHoursPerTask(), createProjectRequest.getUserid());
        }
        NonFixedTask[] projectTasks = Scheduler.ScheduleProject(week, projectTasksToSchedule);
        for (int i = 0; i < 7; i++){
            TaskSerializable taskSer = TasktoTaskSerializableAdapter.TaskToTaskSerializable(projectTasks[i]);
            this.taskSerializableInteractorDataIn.saveTaskSerializable(taskSer);
        }
    }




    }




