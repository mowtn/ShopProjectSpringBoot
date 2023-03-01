package com.example.Shop.Service.Impl;

import com.example.Shop.Domain.Users;
import com.example.Shop.Reponsitory.IUserReponsitory;
import com.example.Shop.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

   @Autowired
    IUserReponsitory iUserReponsitory;
    @Override
    public Optional<Users> findByUsername(String name) {
        return iUserReponsitory.findByUsername(name);
    }

//    @Override
//    public Boolean existByEmail(String email) {
//        return iUserReponsitory.existByEmail(email);
//    }
//
//    @Override
//    public Boolean existByUsername(String name) {
//        return iUserReponsitory.existByUsername(name);
//    }

    @Override
    public Users save(Users users) {
        return iUserReponsitory.save(users);
    }
}
