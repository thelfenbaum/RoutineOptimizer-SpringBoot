package com.csc207.api;

import com.csc207.domain.CreateProject;
import com.csc207.domain.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ProjectController {
    @Autowired
    private final WeekController weekController;

    public ProjectController(WeekController weekController){
        this.weekController = weekController;
    }

    @GetMapping("/project/calculatehours/{userid}-{name}-{totalHours}-{startDateStr}-{dueDateTime}")
    String calculateHours(@PathVariable String userid, @PathVariable String name,
                          @PathVariable String totalHours, @PathVariable String startDateStr,
                          @PathVariable String dueDateTime) {
        Week week = this.weekController.importWeek(Long.getLong(userid));
        LocalDate startDate = LocalDate.of(startDateStr[0:4], startDateStr[4:6], startDateStr[6:8])
        double minHours = CreateProject.calculateMinHours(week, startDate, dueDateTime, totalHours, 7);
    }
}
