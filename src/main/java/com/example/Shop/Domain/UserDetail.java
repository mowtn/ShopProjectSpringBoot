package com.example.Shop.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserDetailId;

    @Column(columnDefinition = "varchar(200)")
    private String address;

    @Column(length = 11)
    private String numberPhone;

    private String gender;

    @Column(columnDefinition = "varchar(100)")
    private String fullName;

    @Column(columnDefinition = "varchar(200)")
    private String avatar;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private Users user;
}
