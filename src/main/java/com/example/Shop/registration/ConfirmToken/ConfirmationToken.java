package com.example.Shop.registration.ConfirmToken;

import com.example.Shop.Domain.Users;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @SequenceGenerator(
            name = "confirmation_sequence",
            sequenceName = "confirmation_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private Users users;

    public ConfirmationToken( String token,
                              LocalDateTime createAt,
                              LocalDateTime expiresAt,
                              Users user) {
        this.token = token;
        this.createAt = createAt;
        this.expiresAt = expiresAt;
        this.users = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getConfirmAt() {
        return confirmAt;
    }

    public void setConfirmAt(LocalDateTime confirmAt) {
        this.confirmAt = confirmAt;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
