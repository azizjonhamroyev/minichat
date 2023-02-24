package uz.azizjonhamroyev.minichat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.azizjonhamroyev.minichat.entities.Message;
import uz.azizjonhamroyev.minichat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/messages")
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

//    @GetMapping("/hello")
//    public ResponseEntity<String> sayHello() {
//        return ResponseEntity.ok("hello");
//    }

    @PostMapping
    public void saveMessage(@RequestBody Message message) {
        messageService.send(message);
    }
}
