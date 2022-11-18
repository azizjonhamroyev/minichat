package uz.azizjonhamroyev.minichat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.azizjonhamroyev.minichat.entities.User;
import uz.azizjonhamroyev.minichat.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
