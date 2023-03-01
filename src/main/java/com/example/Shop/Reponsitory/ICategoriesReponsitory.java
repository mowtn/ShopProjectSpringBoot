package com.example.Shop.Reponsitory;

import com.example.Shop.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriesReponsitory extends JpaRepository<Category,Integer> {
    @Query(value = "select name from Category where name =:value",nativeQuery = true)
    String findByName(String value);
}
