package com.example.Shop.Service.Impl;

import com.example.Shop.Domain.Category;
import com.example.Shop.Reponsitory.ICategoriesReponsitory;
import com.example.Shop.Reponsitory.IUserReponsitory;
import com.example.Shop.Service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoriesSerciveImpl implements ICategoriesService {
    @Autowired
    private ICategoriesReponsitory iCategoriesReponsitory;
    @Autowired
    private IUserReponsitory iUserReponsitory;

    @Override
    public String findByName(String value) {
        return iCategoriesReponsitory.findByName(value);
    }

    @Override
    public Page<Category> findAll(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum-1,5);
        return iCategoriesReponsitory.findAll(pageable);
    }

    @Override
    public List<Category> findAll() {
        return iCategoriesReponsitory.findAll();
    }

    @Override
    public <S extends Category> S save(S entity) {
        return iCategoriesReponsitory.save(entity);
    }

    @Override
    public Optional<Category> findById(Integer integer) {
        return iCategoriesReponsitory.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        iCategoriesReponsitory.deleteById(integer);
    }
}
