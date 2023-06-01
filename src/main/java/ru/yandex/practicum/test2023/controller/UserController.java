package ru.yandex.practicum.test2023.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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
        if (users.size() > 0) {
            log.info("Вывели всех пользователей");
        } else {
            log.info("Пользователей в списке нет");
        }
        return users;
    }

    @DeleteMapping()
    public void delUsers() {
        log.info("Удалили всех пользователей");
        users.clear();
    }

    @RequestMapping("/{id}")
    public User getById(@PathVariable("id") int idUser) {
        log.info("Получили пользователя с id = {} ", idUser);
        return users.get(idUser);
    }

}
