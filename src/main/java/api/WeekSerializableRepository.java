package api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekSerializableRepository extends JpaRepository<WeekSerializable, Long> {

    /**
     * Query a WeekSerializable associated with this user id from the database.
     *
     * @param userId: the user id.
     * @return the WeekSerializable associated with this user id.
     */
    @Query("Select w from WeekSerializable w where w.userId = :userId")
    WeekSerializable getWeekByUserId(Long userId);
}
