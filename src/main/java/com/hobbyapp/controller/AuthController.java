package com.hobbyapp.controller;

import com.hobbyapp.dto.AuthenticationRequest;
import com.hobbyapp.provider.JwtTokenProvider;
import com.hobbyapp.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenProvider tokenProvider;

    private final ReactiveAuthenticationManager authenticationManager;
    private final ManagerService managerService;

    @PostMapping("/login")
    public Mono<ResponseEntity> login(@RequestBody Mono<AuthenticationRequest> authRequest) {
        return authRequest
                .flatMap(login -> this.authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()))
                        .map(this.tokenProvider::createToken)
                )
                .map(jwt -> {
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
                    var tokenBody = Map.of("access_token", jwt);
                    return new ResponseEntity<>(tokenBody, httpHeaders, HttpStatus.OK);
                });

    }

    @PostMapping("/manager")
    public Mono<ResponseEntity> loginManager(@RequestBody Mono<AuthenticationRequest> authRequest) {
        return managerService.loginManager(authRequest);
    }
}
