package ktminithteam.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktminithteam.SubscribermanagementApplication;
import ktminithteam.domain.Verified;
import lombok.Data;

@Entity
@Table(name = "Subscriber_table")
@Data
//<<< DDD / Aggregate Root
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phoneNumber;

    private String telecom;

    private Boolean isRecommended;

    private String subscription;

    @PostPersist
    public void onPostPersist() {
        Verified verified = new Verified(this);
        verified.publishAfterCommit();
    }

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscribermanagementApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }

    //<<< Clean Arch / Port Method
    public void joinMembership() {
        //implement business logic here:

        SignedUp signedUp = new SignedUp(this);
        signedUp.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
