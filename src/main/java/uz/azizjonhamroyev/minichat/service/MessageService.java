package uz.azizjonhamroyev.minichat.service;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import uz.azizjonhamroyev.minichat.entities.Message;
import uz.azizjonhamroyev.minichat.entities.User;
import uz.azizjonhamroyev.minichat.repository.MessageRepository;
import uz.azizjonhamroyev.minichat.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;

    private final UserRepository userRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void send(Message message) {
        User sender = userRepository.findById(message.getSenderId()).get();
        message.setSender(sender);
        messageRepository.save(message);
        messagingTemplate.convertAndSend("/queue/message", message);
    }

}
