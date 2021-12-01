package com.csc207.api;

import com.csc207.domain.WeekSerializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

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
    Collection<WeekSerializable> getByUserId(Long userId);

}
