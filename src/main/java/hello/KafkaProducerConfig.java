package hello;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {


    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
        		ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,   "localhost:9093,localhost:9094");
        configProps.put(   ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,       StringSerializer.class);
        configProps.put(      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,      StringSerializer.class);

        
        //--
        
        //configProps.put(ProducerConfig.RETRIES_CONFIG,   "3");
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG,   "2");
//        configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,   "30000");
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG,   "10");
                //configProps.put(ProducerConfig.ACKS_CONFIG,   "1");

        		
        		
        
        return new DefaultKafkaProducerFactory<>(configProps);
        
        		
        		
    }
 
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
    
}
