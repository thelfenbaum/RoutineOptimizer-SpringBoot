package com.csc207.api;
import com.csc207.domain.TaskSerializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskSerializableRepository extends JpaRepository<TaskSerializable, Long>{
    /**
     * Get all tasks of the user from the database.
     *
     * @param userId: The userid of the tasks we are searching for.
     * @return the arraylist of TaskSerializable objects of the userid.
     */
    @Query("Select t from TaskSerializable t where t.userId = :userId")
    Collection<TaskSerializable> getTasksByUserId(Long userId);
}
