package demo.kafka.consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {

    private static final String TOPIC_NAME = "my-first-topic";

    @KafkaListener(topics = TOPIC_NAME, groupId = "my-consumer-group")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Process the message as needed
    }
}
