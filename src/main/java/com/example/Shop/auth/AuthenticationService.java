package com.example.Shop.auth;


import com.example.Shop.Domain.Role;
import com.example.Shop.Domain.Users;
import com.example.Shop.Reponsitory.IUserReponsitory;
import com.example.Shop.Service.JwtService;
import com.example.Shop.token.Token;
import com.example.Shop.token.TokenRepository;
import com.example.Shop.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final IUserReponsitory repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  private final IUserReponsitory iUserReponsitory;

  public AuthenticationResponse register(Users user) {
//    Boolean existUser = iUserReponsitory.findByEmail(users.getEmail()).isPresent();
//    if(existUser){
//      System.out.println("User exist");
//      return null;
//    }else {
//      var user = Users.builder()
//              .firstname(users.getFirstname())
//              .lastname(users.getLastname())
//              .email(users.getEmail())
//              .password(passwordEncoder.encode(users.getPassword()))
//              .roles(Role.USER)
//              .build();
//      var savedUser = repository.save(user);
      var jwtToken = jwtService.generateToken(user);
      saveUserToken(user, jwtToken);
      return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();

  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    System.out.println("vào authenticate");
    try{
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      request.getEmail(),
                      request.getPassword()
              )
      );
    }
    catch(Exception e){
      System.out.println("Không thành công: "+ e.getMessage());
    }
    Users user = repository.findByEmail(request.getEmail()).get();
    System.out.println("user: "+user);
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);//xóa toàn bộ token trước đó
    saveUserToken(user, jwtToken);
    System.out.println("tạo xong token mới");
    return AuthenticationResponse.builder()// sau khi chứng thực thành công lưu trữ thông tin tm thời sử dụng cho các thao tác tiếp theo
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(Users user, String jwtToken) {

    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(Users user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty()){
      System.out.println("revoke All user is null");
      return;
    }
    validUserTokens.forEach(token -> {
      token.setRevoked(true);
      token.setExpired(true);
      System.out.println("Token:  "+token);
      tokenRepository.save(token);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
