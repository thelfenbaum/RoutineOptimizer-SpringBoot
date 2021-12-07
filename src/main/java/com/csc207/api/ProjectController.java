package com.csc207.api;

import com.csc207.domain.CreateProject;
import com.csc207.domain.StringToDateTime;
import com.csc207.domain.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class ProjectController {
    @Autowired
    private final WeekController weekController;

    public ProjectController(WeekController weekController){
        this.weekController = weekController;
    }

    @GetMapping("/project/calculatehours/{userid}-{totalHoursStr}-{startDateStr}-{dueDateTimeStr}")
    String calculateHours(@PathVariable String userid,
                          @PathVariable String totalHoursStr, @PathVariable String startDateStr,
                          @PathVariable String dueDateTimeStr) {
        Week week = this.weekController.importWeek(Long.getLong(userid));
        LocalDate startDate = StringToDateTime.stringToLocalDate(startDateStr);
        LocalDateTime dueDateTime = StringToDateTime.stringToLocalDateTime(dueDateTimeStr);
        int totalHours = Integer.parseInt(totalHoursStr);
        double minHours = CreateProject.calculateMinHours(week, startDate, dueDateTime, totalHours, 7);
        double maxHours = CreateProject.calculateMaxHoursWeek()
    }
}
