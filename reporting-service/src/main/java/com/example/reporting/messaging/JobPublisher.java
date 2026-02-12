package com.example.reporting.messaging;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobPublisher {

  private final RabbitTemplate rabbitTemplate;

  public JobPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publishJobCreated(UUID jobId, UUID orgId, UUID userId, String originalFileKey, List<String> formats) {
    Map<String, Object> event = Map.of(
        "eventId", UUID.randomUUID().toString(),
        "eventType", "report.job.created",
        "occurredAt", Instant.now().toString(),
        "payload", Map.of(
            "jobId", jobId.toString(),
            "orgId", orgId.toString(),
            "userId", userId.toString(),
            "originalFileKey", originalFileKey,
            "requestedFormats", formats));
    rabbitTemplate.convertAndSend("reporting.events", "report.job.created", event);
  }
}
