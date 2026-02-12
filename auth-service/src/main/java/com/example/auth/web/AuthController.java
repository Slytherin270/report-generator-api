package com.example.auth.web;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public Map<String, Object> signup(@RequestBody Map<String, Object> body) {
    return Map.of("message", "Employee signup accepted", "payload", body);
  }

  @PostMapping("/login")
  public Map<String, Object> login(@RequestBody Map<String, Object> body) {
    return Map.of("accessToken", "jwt-placeholder", "refreshToken", "refresh-placeholder", "input", body);
  }

  @PostMapping("/refresh")
  public Map<String, String> refresh(@RequestBody Map<String, String> body) {
    return Map.of("accessToken", "jwt-placeholder", "refreshToken", body.getOrDefault("refreshToken", ""));
  }

  @PostMapping("/logout")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void logout(@RequestBody Map<String, String> ignored) {}

  @GetMapping("/me")
  public Map<String, String> me() {
    return Map.of("role", "EMPLOYEE", "status", "ACTIVE");
  }
}
