//package com.example.Shop.Sercurity.jwt;
//
//import com.example.Shop.Sercurity.userprincal.UserPrinciple;
//import io.jsonwebtoken.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtProvider {//create token
//    private  static final Logger logger = LoggerFactory.getLogger(JwtProvider.class); //slf4j
//    private String jwtSecret = "nguyencongmanh";
//     private  int jwtExpiration = 86400;
//
//     public String CreateToken(Authentication authentication){
//         UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal(); // tajo ra 1 userprincal va lay ra gia tri hien tai trong he thong
//         return Jwts.builder().setSubject(userPrinciple.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+jwtExpiration*1000)) //build lên 1 token và set subject(nội dunh) cho nó
//                 .signWith(SignatureAlgorithm.ES512,jwtSecret) //chọn chuẩn mã hóa và đưa vào key bí mật
//                 .compact();// lệnh đóng lại nội dung web token
//     }
//     public boolean ValidateToken(String token){
//         try{
//             Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token); // par r chuyền vào mật mã và chuyền vào token để bắt lỗi
//             return true;
//         }catch (SignatureException e){
//            logger.error("Invalid Jwt sinature -> Mess:{}",e);
//         }catch (MalformedJwtException e) {
//             logger.error("Invalid format -> Mess:{}", e);
//         } catch (ExpiredJwtException e) {
//             logger.error("Expired JWT token trace-> Mess:{}", e);
//         } catch (UnsupportedJwtException e) {
//             logger.error("Unsupported JWT token trace-> Mess:{}", e);
//         } catch (IllegalArgumentException e) {
//             logger.error("JWT token compact of handler are invalid trace -> Mess:{}", e);
//         }
//         return false;
//     }
//     public String getUsernameFromToken(String token){
//       String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody().getSubject();
//       return username;
//     }
//
//}
