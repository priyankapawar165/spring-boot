package demo.kafka;
import demo.kafka.producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaApplication implements CommandLineRunner {

	@Autowired
	private KafkaMessageProducer kafkaMessageProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaMessageProducer.sendMessage("Hello Kafka!");
	}
}
