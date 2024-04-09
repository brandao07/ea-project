package com.example.eaproject.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
            generator = "uuid2"
    )
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "created", columnDefinition = "timestamp with time zone", nullable = false)
    private ZonedDateTime created;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @PrePersist
    public void prePersist() {
        created = ZonedDateTime.now();
        deleted = false;
    }
}

