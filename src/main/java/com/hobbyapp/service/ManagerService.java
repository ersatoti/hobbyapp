package com.hobbyapp.service;

import com.hobbyapp.dto.AuthenticationRequest;
import com.hobbyapp.model.Manager;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface ManagerService extends IService<Manager>{

    Mono<ResponseEntity> loginManager(Mono<AuthenticationRequest> authRequest);

}
