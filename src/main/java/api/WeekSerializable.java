package api;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Weeks")
public class WeekSerializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_date")
    public LocalDate startDate;
    @Column(name = "user_id")
    public Long userId;

    protected WeekSerializable(){}

    public WeekSerializable(LocalDate startDate, Long userId){
        this.startDate = startDate;
        this.userId = userId;
    }



}
