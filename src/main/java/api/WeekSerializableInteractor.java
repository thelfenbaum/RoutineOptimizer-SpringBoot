package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Configuration
public class WeekSerializableInteractor {
    @Autowired
    WeekSerializableRepository repo;

    public WeekSerializableInteractor(WeekSerializableRepository wsr){
        this.repo = wsr;
    }

    @Transactional
    public void saveWeekSerializable(WeekSerializable weekSer){
        this.repo.save(weekSer);
    }

    /** Returns the Week associated with a user.
     *
     * @param userId: the id of the user.
     *
     */
    public WeekSerializable getWeekSerializableByUserId(Long userId){
        return this.repo.getWeekByUserId(userId);
    }

    @Transactional
    public void removeWeekSerializableByUserId(long userId) {
        WeekSerializable weekSer = this.repo.getWeekByUserId(userId);
        Long id = weekSer.userId;
        this.repo.deleteAllById(Collections.singleton(id));
    }
}
