package uz.azizjonhamroyev.minichat.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.azizjonhamroyev.minichat.entities.User;
import uz.azizjonhamroyev.minichat.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/by-phone-number/{phoneNumber}")
    public @ResponseBody User getUserByPhoneNumber(@PathVariable String phoneNumber) {

        return userService.userByPhoneNumber(phoneNumber);
    }

    @GetMapping( "/current")
    public User getUserCurrent() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        return userService.userByPhoneNumber(username);
    }
}
