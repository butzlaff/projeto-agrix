package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.farm.controller.dto.AuthenticationDto;
import com.betrybe.agrix.farm.controller.dto.TokenDto;
import com.betrybe.agrix.farm.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for /auth.
 */
@RestController
@RequestMapping("/auth")
public class Auth {
  private final TokenService tokenService;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public Auth(AuthenticationManager authenticationManager, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }
  
  /**
   * Login.
   */
  @PostMapping("/login")
  public TokenDto login(@RequestBody AuthenticationDto authDto) {
    UsernamePasswordAuthenticationToken usernamePassword =
            new UsernamePasswordAuthenticationToken(
                authDto.username(),
                authDto.password()
        );
        
    Authentication auth = authenticationManager.authenticate(usernamePassword);

    Person person = (Person) auth.getPrincipal();
    String token = tokenService.generateToken(person);

    return new TokenDto(token);
  }
}
