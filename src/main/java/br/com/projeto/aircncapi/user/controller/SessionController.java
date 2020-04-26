package br.com.projeto.aircncapi.user.controller;

import br.com.projeto.aircncapi.user.dto.UserResponse;
import br.com.projeto.aircncapi.user.model.User;
import br.com.projeto.aircncapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    private UserResponse save(@RequestBody User user) {
        return UserResponse.of(repository.save(user));
    }
}
