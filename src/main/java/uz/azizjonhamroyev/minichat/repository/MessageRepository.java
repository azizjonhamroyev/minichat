package uz.azizjonhamroyev.minichat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.azizjonhamroyev.minichat.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
