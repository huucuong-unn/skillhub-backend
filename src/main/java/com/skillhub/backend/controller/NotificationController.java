package com.skillhub.backend.controller;

import com.skillhub.backend.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<?> notify(@RequestBody String message) {
        kafkaProducerService.sendNotification(message);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
