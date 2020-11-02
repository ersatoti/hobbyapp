package com.hobbyapp.repository;

import com.hobbyapp.model.Manager;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ManagerRepository extends ReactiveCrudRepository<Manager, String> {

    Mono<Manager> findByUsername(String username);

}
