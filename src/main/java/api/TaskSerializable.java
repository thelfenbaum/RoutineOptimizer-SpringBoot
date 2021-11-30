package com.csc207.api;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Tasks")
public class TaskSerializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_datetime")
    private LocalDateTime startDateTime;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "is_complete")
    private boolean isComplete;

    @Column(name = "user_id")
    private Long userId;

    protected TaskSerializable() {}

    public TaskSerializable(String name, LocalDateTime startDateTime, LocalTime duration, boolean isComplete, Long userId){
        this.name = name;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.isComplete = isComplete;
        this.userId = userId;
    }

    public String getName(){
        return this.name;
    }

    public LocalDateTime getStartDateTime(){
        return this.startDateTime;
    }

    public LocalTime getDuration(){
        return this.duration;
    }

//    public boolean isComplete() {
//        return isComplete;
//    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return this.id;
    }
}
