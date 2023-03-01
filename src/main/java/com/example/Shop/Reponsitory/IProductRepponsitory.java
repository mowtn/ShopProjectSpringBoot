package com.example.Shop.Reponsitory;

import com.example.Shop.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepponsitory extends JpaRepository<Product,Long> {
}
