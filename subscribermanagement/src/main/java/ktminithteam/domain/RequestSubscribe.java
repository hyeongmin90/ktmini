package ktminithteam.domain;

import java.time.LocalDate;
import java.util.*;
import ktminithteam.domain.*;
import ktminithteam.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RequestSubscribe extends AbstractEvent {

    private Long id;
    private Long publishId;
    private Long userId;
    private Long subscriberId;
    private Long cost;

    public RequestSubscribe(Subscribe aggregate) {
        super(aggregate);
    }

    public RequestSubscribe() {
        super();
    }
}
//>>> DDD / Domain Event
