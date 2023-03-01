package com.example.Shop.Service.Impl;

import com.example.Shop.Domain.Product;
import com.example.Shop.Reponsitory.IProductRepponsitory;
import com.example.Shop.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepponsitory iProductRepponsitory;

    @Override
    public Page<Product> findAll(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum-1,5);
        return iProductRepponsitory.findAll(pageable);
    }

    @Override
    @Deprecated
    public Product getById(Long aLong) {
        return iProductRepponsitory.getById(aLong);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepponsitory.findAll();
    }

    @Override
    public <S extends Product> S save(S entity) {
        return iProductRepponsitory.save(entity);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return iProductRepponsitory.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return iProductRepponsitory.existsById(aLong);
    }

    @Override
    public long count() {
        return iProductRepponsitory.count();
    }

    @Override
    public void deleteById(Long aLong) {
        iProductRepponsitory.deleteById(aLong);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        iProductRepponsitory.deleteAllById(longs);
    }
}
