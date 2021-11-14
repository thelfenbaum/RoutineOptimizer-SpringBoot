package api;

import entities.WeekSerializable;

public class WeekSerializableInteractor {
    WeekSerializableRepository repo;

    /**
     * Construct a WeekSerializableInteractor with the given repository.
     *
     * @param wsr: the weekSerializableRepository
     */

    public WeekSerializableInteractor(WeekSerializableRepository wsr){
        this.repo = wsr;
    }

    /**
     * Save the WeekSerializable object to the database.
     *
     * @param weekSer: the week created by the user.
     */

    public void saveWeekSerializable(WeekSerializable weekSer){
        this.repo.save(weekSer);
    }

    /** Returns the Week associated with a user.
     *
     * @param userId: the id of the user.
     */

    public WeekSerializable getWeekSerializableByUserId(Long userId){
        return this.repo.getWeekByUserId(userId);
    }

}
