package com.example.Shop.Reponsitory;

import com.example.Shop.Domain.Role;
import com.example.Shop.Domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleReponsitory extends JpaRepository<Role,Long> {
Optional<Role> findByName(RoleName name);
}
