package com.hobbyapp.service;

import com.hobbyapp.model.Field;
import com.hobbyapp.model.User;
import reactor.core.publisher.Mono;

public interface UserService extends IService<User>{

    Mono<User> findByUsername(String username);
}
