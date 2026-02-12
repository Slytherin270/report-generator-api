package com.example.reporting.web;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports/analytics")
public class AnalyticsController {
  @GetMapping("/summary")
  public Map<String, Object> summary(@RequestParam(required = false) String orgId) {
    return Map.of("orgId", orgId, "reportsCount", 0, "failuresCount", 0, "successRate", 1.0, "avgDurationMs", 0);
  }

  @GetMapping("/timeseries")
  public Map<String, Object> timeseries() {
    return Map.of("points", List.of());
  }

  @GetMapping("/top-employees")
  public Map<String, Object> topEmployees(@RequestParam(defaultValue = "10") int limit) {
    return Map.of("limit", limit, "items", List.of());
  }
}
