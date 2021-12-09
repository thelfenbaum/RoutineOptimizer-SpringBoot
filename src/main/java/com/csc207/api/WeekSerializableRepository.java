package com.csc207.api;

import com.csc207.domain.WeekSerializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * This class is the database that stores WeekSerializable objects.
 */

@Repository
public interface WeekSerializableRepository extends JpaRepository<WeekSerializable, Long> {

    /**
     * Query a WeekSerializable associated with this user id from the database.
     *
     * @param userId : the user id.
     * @return the WeekSerializable associated with this user id.
     */
    @Query("Select w from WeekSerializable w where w.userId = :userId")
    List<WeekSerializable> getByUserId(Long userId);

    /**
     * Removes a WeekSerializable associated with the given userid from th database.
     * @param userid: the user id.
     */
    @Modifying
    @Query("DELETE FROM WeekSerializable w WHERE w.userId = :userid")
    void removeWeekByUserId(long userid);
}
