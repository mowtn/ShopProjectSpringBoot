package com.example.Shop.Reponsitory;

import com.example.Shop.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserReponsitory extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String name); //tìm kiếm xem email có tồn tại hay không

//    Boolean existByUsername(String name);
//    Boolean existByEmail(String email);

}
