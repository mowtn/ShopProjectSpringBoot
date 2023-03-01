package com.example.Shop.Service;

import com.example.Shop.Domain.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Page<Product> findAll(int pageNum);

    @Deprecated
    Product getById(Long aLong);

    List<Product> findAll();

    <S extends Product> S save(S entity);

    Optional<Product> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void deleteAllById(Iterable<? extends Long> longs);
}
