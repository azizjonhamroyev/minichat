package uz.azizjonhamroyev.minichat.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.azizjonhamroyev.minichat.entities.User;
import uz.azizjonhamroyev.minichat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    public User searchUserByPhoneNumberAndPassword(String phoneNumber, String password) {
        Optional<User> optionalUser = userRepository.findByPhoneNumberAndPassword(phoneNumber, password);

        return optionalUser.orElse(null);
    }

    public User saveUser(User user) {
        Optional<User> phoneNumber = userRepository.findByPhoneNumber(user.getUsername());

        if (phoneNumber.isPresent())
            throw new IllegalStateException("phoneNumber already registered");

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User userByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).get();
    }

}
