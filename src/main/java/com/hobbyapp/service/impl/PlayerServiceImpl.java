package com.hobbyapp.service.impl;

import com.hobbyapp.model.Player;
import com.hobbyapp.repository.PlayerRepository;
import com.hobbyapp.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository repository;

	@Override
	public Mono<Player> create(Player jogador) {
		return this.repository.save(jogador);
	}

	@Override
	public Mono<Player> update(Player jogador) {
		return this.repository.save(jogador);
	}

	@Override
	public Flux<Player> list() {
		return this.repository.findAll();
	}


	@Override
	public Mono<Void> delete(String id) {
		return this.repository.findById(id)
			.flatMap(this.repository::delete);
	}
}
