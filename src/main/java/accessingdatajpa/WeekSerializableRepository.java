package accessingdatajpa;

import com.csc207.routop.WeekSerializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekSerializableRepository extends JpaRepository<WeekSerializable, Long> {
}
