package br.com.projeto.aircncapi.user.controller;

import br.com.projeto.aircncapi.user.dto.UserResponse;
import br.com.projeto.aircncapi.user.model.User;
import br.com.projeto.aircncapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
@CrossOrigin
public class SessionController {

    @Autowired
    private UserService service;

    @PostMapping
    private UserResponse save(@RequestBody User user) {
        return service.save(user);
    }
}
