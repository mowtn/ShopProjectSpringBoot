package com.example.Shop.Service.Impl;

import com.example.Shop.Domain.Users;
import com.example.Shop.Reponsitory.IUserReponsitory;
import com.example.Shop.Service.IUserService;
import com.example.Shop.registration.ConfirmToken.ConfirmationToken;
import com.example.Shop.registration.ConfirmToken.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

   @Autowired
    IUserReponsitory iUserReponsitory;

    private final ConfirmationTokenService confirmationTokenService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static String USER_NOT_FOUND_MSG =
            "user with email not found";
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return iUserReponsitory.findByEmail(s)
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG)));
    }



    @Override
    public String signUpUser(Users user){
        boolean userExist = iUserReponsitory.findByEmail(user.getEmail())
                .isPresent();
        if(userExist){
            throw new IllegalStateException("email already taken");
        }
        String passEncode = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passEncode);
        iUserReponsitory.save(user);
        // create token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public int enableAppUser(String email) {
        return iUserReponsitory.enableAppUser(email);
    }
}
