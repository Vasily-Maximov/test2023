package ru.yandex.practicum.test2023.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import ru.yandex.practicum.test2023.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();
    private int idGenerator = 1;

    @PostMapping
    public User register(@RequestBody User user) {
        user.setId(idGenerator++);
        users.add(user);
        log.info("Создали пользователя lastname: {}, c id: {}", user.getFirstName(), user.getId());
        return user;
    }

    @RequestMapping
    public  List<User> getAllUsers() {
        return users;
    }
}
