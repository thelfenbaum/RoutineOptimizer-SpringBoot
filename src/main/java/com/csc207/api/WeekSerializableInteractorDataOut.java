package com.csc207.api;

import com.csc207.domain.WeekSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is responsible for accessing data about weeks in the database.
 */
@Configuration
public class WeekSerializableInteractorDataOut {
    @Autowired
    WeekSerializableRepository repo;

    /**
     * The constructor for the WeekSerializableInteractorDataOut class.
     * @param wsr: The database that will be accessed to get information.
     */
    public WeekSerializableInteractorDataOut(WeekSerializableRepository wsr){
        this.repo = wsr;
    }

    /** Returns the Week associated with a user.
     *
     * @param userId: the id of the user.
     *
     */
    public WeekSerializable getWeekSerializableByUserId(Long userId){
        ArrayList<WeekSerializable> ws = (ArrayList<WeekSerializable>)this.repo.getByUserId(userId);
        return ws.get(0);
    }

//    /**
//     * Removes the weeks of a user from the database by using the user id.
//     * @param userId: The userid of the weeks that are associated with this user.
//     */
//    @Transactional
//    public void removeWeekSerializableByUserId(long userId) {
//        ArrayList<WeekSerializable> weekSers = (ArrayList<WeekSerializable>)this.repo.getByUserId(userId);
//        WeekSerializable weekSer = weekSers.get(0);
//        Long id = weekSer.getId();
//        this.repo.deleteAllById(Collections.singleton(id));
//    }
}
