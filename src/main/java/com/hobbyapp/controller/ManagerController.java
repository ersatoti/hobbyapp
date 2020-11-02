package com.hobbyapp.controller;

import com.hobbyapp.model.Manager;
import com.hobbyapp.service.ManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController extends RESTController<Manager, Integer> {

    public ManagerController(ManagerService service) {
        super(service);
    }
}
