package com.csc207.api;

import com.csc207.domain.WeekSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

@Configuration
public class WeekSerializableInteractorDataIn {
    @Autowired
    WeekSerializableRepository repo;

    public WeekSerializableInteractorDataIn(WeekSerializableRepository wsr){
        this.repo = wsr;
    }

    @Transactional
    public void saveWeekSerializable(WeekSerializable weekSer){
        this.repo.save(weekSer);
    }
}
