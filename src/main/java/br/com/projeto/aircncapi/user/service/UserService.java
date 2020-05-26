package br.com.projeto.aircncapi.user.service;

import br.com.projeto.aircncapi.user.dto.UserResponse;
import br.com.projeto.aircncapi.user.model.User;
import br.com.projeto.aircncapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserResponse save(User user) {
        var userBase = repository.findByEmail(user.getEmail());
        return userBase.isPresent()
            ? UserResponse.of(userBase.get())
            : UserResponse.of(repository.save(user));
    }
}
