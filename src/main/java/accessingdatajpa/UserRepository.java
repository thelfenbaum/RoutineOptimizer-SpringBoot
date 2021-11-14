package accessingdatajpa;

import com.csc207.routop.Task;
import com.csc207.routop.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Get the user with this username.
     *
     * @param userId: the ID of the user accessing tasks in the database.
     */
    @Query("Select u from User u where u.id = :userId")
    ArrayList<User> getUserById(long userId);

    /**
     * Get the user with this username.
     *
     * @param username: the ID of the user accessing tasks in the database.
     */
    @Query("Select u from User u where u.username = :username")
    ArrayList<User> getUserByUsername(String username);
}
