package com.example.reporting.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
  @Bean
  TopicExchange reportingEventsExchange() { return new TopicExchange("reporting.events"); }

  @Bean
  Queue createdQueue() { return new Queue("report.job.created.q", true); }

  @Bean
  Binding createdBinding(Queue createdQueue, TopicExchange reportingEventsExchange) {
    return BindingBuilder.bind(createdQueue).to(reportingEventsExchange).with("report.job.created");
  }
}
