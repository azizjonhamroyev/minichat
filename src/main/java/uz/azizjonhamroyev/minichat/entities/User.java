package uz.azizjonhamroyev.minichat.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String surname;

    @Column(columnDefinition = "TEXT")
    private String phone_number;

    @Column(columnDefinition = "TEXT")
    private String password;
}
