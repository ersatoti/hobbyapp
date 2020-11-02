package com.hobbyapp.service.impl;

import com.hobbyapp.exception.UserNotFoundException;
import com.hobbyapp.model.User;
import com.hobbyapp.repository.UserRepository;
import com.hobbyapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .switchIfEmpty(Mono.defer(() -> {
                    return Mono.error(new UserNotFoundException("User not found"));
                })).map(user -> {
                    return user;
                });
    }

    @Override
    public Mono<User> create(User model) {
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        return userRepository.save(model);
    }

    @Override
    public Flux<User> list() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> update(User model) {
        return userRepository.save(model);
    }

    @Override
    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }
}
