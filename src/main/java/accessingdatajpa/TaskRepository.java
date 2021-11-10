package accessingdatajpa;

import com.csc207.routop.Task;
import com.csc207.routop.Week;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TaskRepository extends JpaRepository<Week, Long>{
    /**
     * Save this task to the database.
     *
     * @param task: the task to be saved to the database.
     * @param userId: the ID of the user saving this task.
     */
    public void saveTask(Task task, int userId);

    /**
     * Get all tasks on this date from the database.
     *
     * @param taskDate: the date of the tasks we are searching for.
     * @param userId: the ID of the user accessing tasks in the database.
     */
    @Query("SELECT t FROM tasks t WHERE t.start_date = :taskDate")
    public ArrayList<Task> getTaskByDate(LocalDate taskDate, int userId);
}
