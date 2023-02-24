package uz.azizjonhamroyev.minichat.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.azizjonhamroyev.minichat.config.JwtUtils;
import uz.azizjonhamroyev.minichat.dto.UserDTO;
import uz.azizjonhamroyev.minichat.entities.User;
import uz.azizjonhamroyev.minichat.repository.UserRepository;
import uz.azizjonhamroyev.minichat.service.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("api/auth")
@Slf4j
public class AuthenticationController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;

//    @GetMapping(value = "/{phone_number}/{password}")
//    public @ResponseBody User loginByPhoneNumber(@PathVariable("phone_number") String phoneNumber, @PathVariable("password") String password) {
//        return service.searchUserByPhoneNumberAndPassword(phoneNumber, password);
//    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody final User user) {
        return ResponseEntity.ok(jwtUtils.generateToken(service.saveUser(user)));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UserDTO userDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getPhoneNumber(), userDTO.getPassword())
        );

        final UserDetails userDetails = userRepository.findByPhoneNumber(userDTO.getPhoneNumber()).get();

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }


}
