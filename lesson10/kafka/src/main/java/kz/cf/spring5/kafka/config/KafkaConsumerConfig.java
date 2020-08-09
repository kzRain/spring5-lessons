package kz.cf.spring5.kafka.config;

import kz.cf.spring5.kafka.model.Human;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public ConsumerFactory<String, String> consumerFactory(String groupId) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(String groupId) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(groupId));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> codeForceKafkaListenerContanerFactory() {
        return kafkaListenerContainerFactory("codeforce");
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> telegramKafkaListenerContanerFactory() {
        return kafkaListenerContainerFactory("telegrambot");
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> studentKafkaListenerContanerFactory() {
        return kafkaListenerContainerFactory("student");
    }

    public ConsumerFactory<String, Human> consumerHumanFactory(String groupId) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(Human.class));
    }

    public ConcurrentKafkaListenerContainerFactory<String, Human> kafkaHumanListenerContainerFactory(String groupId) {
        ConcurrentKafkaListenerContainerFactory<String, Human> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerHumanFactory(groupId));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Human> codeHumanForceKafkaListenerContanerFactory() {
        return kafkaHumanListenerContainerFactory("codeforce");
    }

}
