//package com.example.Shop.Sercurity.userprincal;
//
//import com.example.Shop.Domain.Users;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserPrinciple implements UserDetails {
//    private Long Id;
//    private String email;
//    private String username;
//    @JsonIgnore
//    private String password;
//
//    public UserPrinciple() {
//    }
//
//    public UserPrinciple(Long id, String email, String username, String password, Collection<? extends GrantedAuthority> roles) {
//        Id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }
//
//    public static UserPrinciple build(Users user){
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> //convert set -> list
//                new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
//        return  new UserPrinciple(
//                user.getUserId(),
//                user.getEmail(),
//                user.getUsername(),
//                user.getPassWord(),
//                authorities
//        );//tra ve 1 doi tuong
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    private Collection<? extends  GrantedAuthority> roles;
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
