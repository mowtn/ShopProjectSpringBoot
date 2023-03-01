package com.example.Shop.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderId;

    @Column(columnDefinition = "varchar(500) not null")
    private String Description;

    @Temporal(TemporalType.DATE)
    private Date CreateDate;

    @Column(nullable = false)
    private int status;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Users users;
}
