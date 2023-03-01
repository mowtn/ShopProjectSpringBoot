//package com.example.Shop.Sercurity.jwt;
//
//import com.example.Shop.Domain.UserDetail;
//import com.example.Shop.Sercurity.userprincal.UserDetailService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
////lớp này sẽ dc thực thi qua sercurity con fig và sử dụng lớp jwt provider
//public class JwtTokenFilter  extends OncePerRequestFilter {
//    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
//    @Autowired
//    private  JwtProvider jwtProvider;
//
//    @Autowired
//    private UserDetailService userDetailService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try{
//            String token = getJwt(request);
//            if(token != null && jwtProvider.ValidateToken(token)){
//                String username = jwtProvider.getUsernameFromToken(token);
//                UserDetails userDetails = userDetailService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                    userDetails,null, userDetails.getAuthorities()
//                );
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }catch (Exception e){
//            logger.error("Can't set user authentication -> Message: "+e);
//        }
//        filterChain.doFilter(request,response);
//    }
//    private String getJwt(HttpServletRequest request){
//        String authHeader = request.getHeader("Authorization");
//        if(authHeader != null && authHeader.startsWith("Bearer")){
//            return authHeader.replace("Bearer","");
//        }
//        return null;
//    }
//}
