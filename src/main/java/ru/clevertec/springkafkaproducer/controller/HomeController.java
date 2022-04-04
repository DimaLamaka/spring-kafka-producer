package ru.clevertec.springkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.springkafkaproducer.model.Message;
import ru.clevertec.springkafkaproducer.producer.ProducerService;

@RestController
@RequestMapping("kafka-api/v1")
public class HomeController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/generate")
    public String generate(@RequestParam String message,
                           @RequestParam Integer age) {
        producerService.produce(new Message(message,age));
        return "OK";
    }
}
