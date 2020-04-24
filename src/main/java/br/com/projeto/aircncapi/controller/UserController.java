package aircnc.api.controller;

import aircnc.api.model.User;
import aircnc.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    private User save(@RequestBody User user) {
        return repository.save(user);
    }
}
