package api;
import entities.TaskSerializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.ArrayList;

public interface TaskSerializableRepository extends JpaRepository<TaskSerializable, Long>{
    /**
     * Get all tasks created by a user with a given userID on this date from the database.
     *
     * @param taskDate: the date of the tasks we are searching for.
     * @param userId: the ID of the user accessing tasks in the database.
     * @return a list of tasks that takes place
     */
    @Query("Select t from TaskSerializable t where t.startDateTime = :taskDate and t.id = :userId")
    ArrayList<TaskSerializable> getTaskByDate(LocalDate taskDate, double userId);


    @Query("Select t from TaskSerializable t where t.userId = :userId")
    ArrayList<TaskSerializable> getTasksByUserId(long userId);
}
