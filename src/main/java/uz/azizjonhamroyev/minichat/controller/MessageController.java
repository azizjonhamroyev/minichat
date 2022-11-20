package uz.azizjonhamroyev.minichat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.azizjonhamroyev.minichat.entities.Message;
import uz.azizjonhamroyev.minichat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @PostMapping
    public void saveMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }
}
