package com.example.Shop.Service.Impl;

import com.example.Shop.Domain.Role;
import com.example.Shop.Domain.RoleName;
import com.example.Shop.Reponsitory.IRoleReponsitory;
import com.example.Shop.Service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
   @Autowired
    IRoleReponsitory roleRep;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRep.findByName(name);
    }
}
