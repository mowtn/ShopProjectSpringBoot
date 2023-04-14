package com.example.Shop.auth;

import com.example.Shop.Domain.Users;
import com.example.Shop.Service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  private final RegistrationService registrationService;

  @PostMapping("/register")
  public ResponseEntity<String> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(registrationService.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @GetMapping("/confirm")
  public AuthenticationResponse confirm(@RequestParam(name = "token") String token){
    Users user = registrationService.confirmToken(token);
    return service.register(user);
  }


}
