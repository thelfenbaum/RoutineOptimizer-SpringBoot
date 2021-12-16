package com.csc207.api;

import com.csc207.domain.WeekSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

/**
 * This class is responsible for saving data to the week database.
 */

@Configuration
public class WeekSerializableInteractorDataIn {
    @Autowired
    WeekSerializableRepository repo;

    /**
     * Constructor for the WeekSerializableInteractorDataIn class.
     * @param wsr: The database that is being used to save information.
     */
    public WeekSerializableInteractorDataIn(WeekSerializableRepository wsr){
        this.repo = wsr;
    }

    /**
     * Saves the WeekSerializable object to the database.
     * @param weekSer: The WeekSerializable that will be saved in the database.
     */
//    @Transactional
    public void saveWeekSerializable(WeekSerializable weekSer){
        this.repo.save(weekSer);
    }

    /**
     * Removes the week associated with the userid
     * @param userid: The user id
     */
    public void removeWeekByUserId(long userid){
        this.repo.removeWeekByUserId(userid);
    }
}
