package ktminithteam.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Subscribe_table")
@Data
public class Subscribe {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long subscribeId;

    private Long subscriberId;
    private Long publishId;
    private Date expriationDate;
}
