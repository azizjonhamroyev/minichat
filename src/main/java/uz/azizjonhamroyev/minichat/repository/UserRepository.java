package uz.azizjonhamroyev.minichat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.azizjonhamroyev.minichat.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByPhoneNumberAndPassword(String phoneNumber, String password);


}
