package com.meggalord.expense_collector.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping()
    public String createUser(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
