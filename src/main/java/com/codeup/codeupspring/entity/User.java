package com.codeup.codeupspring.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "username", nullable = false)
    private String username;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
}
