package com.example.reporting.web;

import com.example.reporting.messaging.JobPublisher;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/reports")
public class ReportController {

  private final JobPublisher jobPublisher;

  public ReportController(JobPublisher jobPublisher) {
    this.jobPublisher = jobPublisher;
  }

  @PostMapping("/jobs")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Map<String, Object> createJob(@RequestParam("file") MultipartFile file,
                                       @RequestParam(name = "formats", required = false) List<String> formats) {
    UUID jobId = UUID.randomUUID();
    List<String> requested = formats == null || formats.isEmpty() ? List.of("PDF") : formats;
    jobPublisher.publishJobCreated(jobId, UUID.randomUUID(), UUID.randomUUID(), "uploads/" + file.getOriginalFilename(), requested);
    return Map.of("jobId", jobId, "status", "PENDING", "formats", requested);
  }

  @GetMapping("/jobs/{jobId}")
  public Map<String, Object> status(@PathVariable String jobId) {
    return Map.of("jobId", jobId, "status", "PROCESSING");
  }

  @GetMapping("/history")
  public Map<String, Object> history(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "20") int size) {
    return Map.of("items", List.of(), "page", page, "size", size, "totalElements", 0);
  }
}
