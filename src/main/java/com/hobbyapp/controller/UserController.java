package com.hobbyapp.controller;

import com.hobbyapp.model.User;
import com.hobbyapp.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends RESTController<User, Integer> {

    public UserController(UserService service) {
        super(service);
    }
}
