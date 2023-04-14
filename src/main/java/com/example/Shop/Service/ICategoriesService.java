package com.example.Shop.Service;

import com.example.Shop.Domain.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICategoriesService {

    String findByName(String value);
    Page<Category> findAll(int pagenum);

    List<Category> findAll();

    <S extends Category> S save(S entity);

    Optional<Category> findById(Integer integer);

    void deleteById(Integer integer);

}
