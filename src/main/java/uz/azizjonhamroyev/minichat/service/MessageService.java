package uz.azizjonhamroyev.minichat.service;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import uz.azizjonhamroyev.minichat.entities.Message;
import uz.azizjonhamroyev.minichat.repository.MessageRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
        messagingTemplate.convertAndSend("/queue/messages", message);
    }


}
