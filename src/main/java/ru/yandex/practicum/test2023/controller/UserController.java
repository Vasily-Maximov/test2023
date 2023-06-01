package ru.yandex.practicum.test2023.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public User createUser(@RequestBody User user) {
        user.setId(idGenerator++);
        users.add(user);
        log.info("Создали пользователя lastname: {}, c id: {}", user.getFirstName(), user.getId());
        return user;
    }

    @RequestMapping
    public  List<User> getAllUsers() {
        return users;
    }

    @DeleteMapping()
    public void delUsers() {
        users.clear();
    }

    @DeleteMapping("/{id}")
    public void delUserById(@PathVariable("id") int idUser) {
        if (users.size() >= idUser) {
            log.info("Удалили пользователя с именем: {}, и id: {}", users.get(idUser).getFirstName(), users.get(idUser).getId());
            users.remove(idUser-1);
        } else {
            log.info("Пользователь с id = {} не найден", idUser);
        }
    }


}
