package com.example.Shop.Service;

import com.example.Shop.Domain.Role;
import com.example.Shop.Domain.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
