package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class TaskSerializableInteractor {
    @Autowired
    private final TaskSerializableRepository taskSerRepo;

    public TaskSerializableInteractor(TaskSerializableRepository taskSerRepo){
        this.taskSerRepo = taskSerRepo;
    }

    @Transactional
    public void saveTaskSerializable(TaskSerializable taskSer){
        this.taskSerRepo.save(taskSer);
    }
    /** Returns a list of tasks associated with a user.
     *
     * @param userId: the id of the user.
     */
    public ArrayList<TaskSerializable> getTasksByUserId(Long userId) {
        return (ArrayList<TaskSerializable>) this.taskSerRepo.getTasksByUserId(userId);
    }

    @Transactional
    public void removeTaskSerializablesByUserId(long userId) {
        ArrayList<Long> listOfIds = new ArrayList<Long>();
        ArrayList<TaskSerializable> taskSers = getTasksByUserId(userId);
        for(TaskSerializable taskSer: taskSers){
            listOfIds.add(taskSer.getUserId());
        }
        this.taskSerRepo.deleteAllById(listOfIds);
    }
}
