package com.example.Shop.Service;

import com.example.Shop.Domain.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    String signUpUser(Users appUser);

    int enableAppUser(String email);
}
