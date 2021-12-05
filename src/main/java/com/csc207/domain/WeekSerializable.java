package com.csc207.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * This class represents a serializable week so that it can be stored in a database.
 */

@Entity
@Table(name = "weeks")
public class WeekSerializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "start_date")
    public LocalDate startDate;
    @Column(name = "user_id")
    public Long userId;

    protected WeekSerializable(){}

    /**
     * The constructor that creates the WeekSerializable object.
     * @param startDate: The start date of the week.
     * @param userId: The user id of the week.
     */
    public WeekSerializable(LocalDate startDate, Long userId){
        this.startDate = startDate;
        this.userId = userId;
    }

    /**
     * Gets the id.
     * @return The id of the week.
     */
    public Long getId() {
        return this.id;
    }
}
