package api;

import entities.WeekSerializable;

public class WeekSerializableInteractor {
    WeekSerializableRepository repo;

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
