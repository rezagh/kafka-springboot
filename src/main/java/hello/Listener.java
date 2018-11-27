package hello;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	
	@KafkaListener(topics = "test" )
	public void listen(String message) {
	    System.out.println(message);
	}
}
