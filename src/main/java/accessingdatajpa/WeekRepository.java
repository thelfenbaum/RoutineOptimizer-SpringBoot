package accessingdatajpa;
import com.csc207.routop.Task;
import com.csc207.routop.Week;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.ArrayList;

public interface WeekRepository extends JpaRepository<Task, Long>{

    /**
     * Get all tasks on this date from the database.
     *
     * @param taskDate: the date of the tasks we are searching for.
     * @param userId: the ID of the user accessing tasks in the database.
     */
    @Query("Select w from Week w where = :taskDate")
    Week getWeekByDate(LocalDate taskDate, int userId);
}
