package com.hobbyapp.service.impl;

import com.hobbyapp.dto.AuthenticationRequest;
import com.hobbyapp.model.Manager;
import com.hobbyapp.provider.JwtTokenProvider;
import com.hobbyapp.repository.ManagerRepository;
import com.hobbyapp.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository repository;
    private final ReactiveAuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Override
    public Mono<Manager> create(Manager gestor) {
        return this.repository.save(gestor);
    }

    @Override
    public Mono<Manager> update(Manager gestor) {
        return this.repository.save(gestor);
    }

    @Override
    public Flux<Manager> list() {
        return this.repository.findAll();
    }


    @Override
    public Mono<Void> delete(String id) {
        return this.repository.findById(id)
                .flatMap(this.repository::delete);
    }

    @Override
    public Mono<ResponseEntity> loginManager(Mono<AuthenticationRequest> authRequest) {
        AtomicReference<String> username = new AtomicReference<>("");
        return authRequest
                .flatMap(login -> {
                            username.set(login.getUsername());
                            return this.authenticationManager
                                    .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()))
                                    .map(this.tokenProvider::createToken);
                        }
                )
                .map(jwt -> {
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
                    Map<String, Object> body = new HashMap<>();
                    body.put("access_token", jwt);
                    body.put("manager", this.repository.findByUsername(username.get()).block());
                    return new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);
                });
    }
}
