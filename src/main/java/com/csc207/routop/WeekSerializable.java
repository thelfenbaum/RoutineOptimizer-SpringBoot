package com.csc207.routop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class WeekSerializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    public LocalDate startDate;
    public Long userId;

    protected WeekSerializable(){}

    public WeekSerializable(LocalDate startDate, Long userId){
        this.startDate = startDate;
        this.userId = userId;
    }



}
