package uz.azizjonhamroyev.minichat.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(columnDefinition = "TEXT")
    private String content;


    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime sentTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "sender_id", insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private User sender;

}
