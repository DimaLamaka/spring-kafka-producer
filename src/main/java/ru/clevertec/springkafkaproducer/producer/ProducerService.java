package ru.clevertec.springkafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.clevertec.springkafkaproducer.model.Message;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void produce(Message message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("messages", message);
    }
}
