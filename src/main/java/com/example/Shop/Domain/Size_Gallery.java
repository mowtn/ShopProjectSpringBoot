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
public class Size_Gallery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(nullable = false)
    private String nameSize;

    @Column(nullable = false)
    private int quantity;

}
