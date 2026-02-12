package com.example.reporting.worker;

import com.example.reporting.service.PdfGenerator;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JobCreatedConsumer {
  private final PdfGenerator pdfGenerator;

  public JobCreatedConsumer(PdfGenerator pdfGenerator) {
    this.pdfGenerator = pdfGenerator;
  }

  @RabbitListener(queues = "report.job.created.q")
  public void consume(Map<String, Object> event) {
    // skeleton async worker
    pdfGenerator.generate("Generated report", "This is a generated content skeleton");
  }
}
