//package com.cib.auth.kafka;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class KafkaProducerService {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public void publishAuthEvent(String topic, String message) {
//        kafkaTemplate.send(topic, message);
//        log.info(" Kafka Event Published to topic [{}]: {}", topic, message);
//    }
//}
