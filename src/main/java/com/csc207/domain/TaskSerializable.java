package com.csc207.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class represents a serializable task, so that it can be stored in the database.
 */

@Entity
@Table(name = "tasks")
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

    /**
     * The constructor for the TaskSerializable class that gives the TaskSerializable object its name, start date,
     * duration, completion status, and the user id of the user.
     * @param name: Name of the task
     * @param startDateTime: Start date and time of the task
     * @param duration: The duration of the task
     * @param isComplete: The completion status of the task
     * @param userId: The id of the user of the task
     */

    public TaskSerializable(String name, LocalDateTime startDateTime, LocalTime duration, boolean isComplete, Long userId){
        this.name = name;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.isComplete = isComplete;
        this.userId = userId;
    }

    /**
     * Gets the name.
     * @return The name of the taskSerializable.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the start date and time.
     * @return The start date and time of the TaskSerializable.
     */
    public LocalDateTime getStartDateTime(){
        return this.startDateTime;
    }

    /**
     * Gets the duration.
     * @return The duration of the TaskSerializable object.
     */
    public LocalTime getDuration(){
        return this.duration;
    }

    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Gets the user id.
     * @return The user id of the TaskSerializable object.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Gets the id.
     * @return The id of the TaskSerializable object.
     */
    public Long getId() {
        return this.id;
    }
}
