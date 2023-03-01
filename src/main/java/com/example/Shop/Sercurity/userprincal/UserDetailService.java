//package com.example.Shop.Sercurity.userprincal;
//
//import com.example.Shop.Domain.Users;
//import com.example.Shop.Reponsitory.IUserReponsitory;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailService implements UserDetailsService {
//    @Autowired
//    IUserReponsitory iUserReponsitory;
//    @Override
//    @Transactional // lien quan den database
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // chuc nang tim user trong database exist?
//        Users users = iUserReponsitory.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found -> username or password"+ username));//bat ngoai le
//        return UserPrinciple.build(users); //sau khi xac dinh user ton tai thi build mot user trong he thong bang lop princal
//    }
//}
