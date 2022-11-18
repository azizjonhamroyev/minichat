package uz.azizjonhamroyev.minichat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.azizjonhamroyev.minichat.entities.Message;
import uz.azizjonhamroyev.minichat.repository.MessageRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }


}
