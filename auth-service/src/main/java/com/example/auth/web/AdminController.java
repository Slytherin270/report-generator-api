package com.example.auth.web;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @PostMapping("/organizations")
  @ResponseStatus(HttpStatus.CREATED)
  public Map<String, String> createOrg(@RequestBody Map<String, Object> body) {
    return Map.of("message", "Organization and org head created", "name", String.valueOf(body.get("name")));
  }

  @PatchMapping("/organizations/{orgId}/status")
  public Map<String, String> setOrgStatus(@PathVariable String orgId, @RequestBody Map<String, String> body) {
    return Map.of("orgId", orgId, "status", body.getOrDefault("status", "ACTIVE"));
  }

  @PatchMapping("/users/{userId}/status")
  public Map<String, String> setUserStatus(@PathVariable String userId, @RequestBody Map<String, String> body) {
    return Map.of("userId", userId, "status", body.getOrDefault("status", "ACTIVE"));
  }
}
