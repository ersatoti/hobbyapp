package com.hobbyapp.service;

import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IService<T> {

	Mono<T> create(T model);

	Flux<T> list();

	@Transactional Mono<T> update(T model);

	@Transactional Mono<Void> delete(String id);
}
