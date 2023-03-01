package com.example.Shop.Service;

import com.example.Shop.Domain.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    Optional<Users> findByUsername(String name); //tìm kiếm xem email có tồn tại hay không

//    Boolean existByUsername(String name);
//    Boolean existByEmail(String email);
    Users save(Users users);
}
