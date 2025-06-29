package ktminithteam.domain;

import java.util.*;
import ktminithteam.domain.*;
import ktminithteam.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class RequestSubscribe extends AbstractEvent {

    private Long id;
    private Long publishId;
    private Long userId;
    private Long subscriberId;
    private Long cost;
}
