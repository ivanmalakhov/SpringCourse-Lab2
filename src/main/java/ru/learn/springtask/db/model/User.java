package ru.learn.springtask.db.model;

import lombok.*;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username")
    private String userName;
    private String fio;
    @OneToMany(mappedBy = "user")
    private final List<Login> logins = new ArrayList<>();

    public void addLogin(Login login) {
        this.logins.add(login);
    }
}
