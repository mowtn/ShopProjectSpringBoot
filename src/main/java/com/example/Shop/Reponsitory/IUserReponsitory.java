package com.example.Shop.Reponsitory;

import com.example.Shop.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IUserReponsitory extends JpaRepository<Users,Integer> {
    Optional<Users> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET enable = true WHERE email = :email",nativeQuery = true)
    int enableAppUser(String email);

}
