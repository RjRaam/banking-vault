package com.bankingvault.backend.model;


import com.bankingvault.backend.config.CryptoConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255)
    @Convert(converter = CryptoConverter.class)
    private String cardNumberEncrypted;

    @Column(nullable = false, length = 7)
    private String expiryDate;

    @Column(nullable = false, length = 255)
    private String cvvEncrypted;

    @Column(nullable = false, length = 255)
    private String pinEncrypted;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

}

