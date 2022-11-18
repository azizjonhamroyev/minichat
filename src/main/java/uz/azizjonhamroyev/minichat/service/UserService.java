package uz.azizjonhamroyev.minichat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.azizjonhamroyev.minichat.entities.User;
import uz.azizjonhamroyev.minichat.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
