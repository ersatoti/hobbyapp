/*
package com.hobbyapp.runner;

import com.hobbyapp.model.User;
import com.hobbyapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Component
public class UserInitialRunner implements CommandLineRunner {

    private final UserRepository userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        String usernameAdmin = "admin";
        userService.save(User.builder()
                .username(usernameAdmin)
                .password(passwordEncoder.encode("123"))
                .roles(Arrays.asList("ROLE_ADMIN"))
                .active(true)
                .build())
                .subscribe();
    }
}

*/
