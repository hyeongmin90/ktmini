package ktminithteam.domain;

import java.time.LocalDate;
import java.util.*;
import ktminithteam.domain.*;
import ktminithteam.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishRequestedEvent extends AbstractEvent {

    private Long manuscriptId;
    private Long authorId;
    private String title;
    private Date requestedAt;
    private String content;

    public PublishRequestedEvent(Manuscript aggregate) {
        super(aggregate);
    }

    public PublishRequestedEvent() {
        super();
    }
}
//>>> DDD / Domain Event
