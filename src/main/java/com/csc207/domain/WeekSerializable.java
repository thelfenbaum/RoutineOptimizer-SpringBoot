package com.csc207.domain;

import javax.persistence.*;
import java.time.LocalDate;

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

    public WeekSerializable(LocalDate startDate, Long userId){
        this.startDate = startDate;
        this.userId = userId;
    }


    public Long getId() {
        return this.id;
    }
}
