package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

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

}
