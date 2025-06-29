package ktminithteam.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import ktminithteam.config.kafka.KafkaProcessor;
import ktminithteam.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SubscribeViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SubscribeRepository subscribeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSubscribeSucceed_then_CREATE_1(
        @Payload SubscribeSucceed subscribeSucceed
    ) {
        try {
            if (!subscribeSucceed.validate()) return;

            // view 객체 생성
            Subscribe subscribe = new Subscribe();
            // view 객체에 이벤트의 Value 를 set 함
            subscribe.setSubscribeId(String.valueOf(subscribeSucceed.getId()));
            subscribe.setExpriationDate(subscribeSucceed.getExpirationDate());
            subscribe.setBookId(subscribeSucceed.getBookId());
            // view 레파지 토리에 save
            subscribeRepository.save(subscribe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
