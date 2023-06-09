package ru.yandex.practicum.test2023.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.test2023.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class DirectorController {

    private final List<User> directors = new ArrayList<>();

    private int idGenerator = 1;

    @PostMapping
    public User register(@RequestBody User user) {
        user.setId(idGenerator++);
        directors.add(user);
        log.info("Создали пользователя lastname: {}, c id: {}", user.getFirstName(), user.getId());
        return user;
    }

    @RequestMapping
    public  List<User> getAllUsers() {
        return directors;
    }

    @DeleteMapping()
    public void delUsers() {
        directors.clear();
    }

    @DeleteMapping("/{id}")
    public void delDirectorById(@PathVariable("id") int idUser) {
        if (directors.size() >= idUser) {
            log.info("Удалили директора с именем: {}, и id: {}", directors.get(idUser).getFirstName(), directors.get(idUser).getId());
            directors.remove(idUser-1);
        } else {
            log.info("Директор с id = {} не найден", idUser);
        }
    }
}
