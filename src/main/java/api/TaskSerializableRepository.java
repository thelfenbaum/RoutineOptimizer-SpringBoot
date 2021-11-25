package api;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface TaskSerializableRepository extends JpaRepository<TaskSerializable, Long>{
    /**
     * Get all tasks on this date from the database.
     *
     * @param taskDate: the date of the tasks we are searching for.
     * @param userId: the ID of the user accessing tasks in the database.
     */
    @Query("Select t from TaskSerializable t where t.startDateTime = :taskDate")
    ArrayList<TaskSerializable> getTaskByDate(LocalDate taskDate, double userId);

    /**
     * Get all tasks of the user from the database.
     *
     * @param userId: The userid of the tasks we are searching for.
     * @return the arraylist of TaskSerializable objects of the userid.
     */
    @Query("Select t from TaskSerializable t where t.userId = :userId")
    Collection<TaskSerializable> getTasksByUserId(Long userId);
}
