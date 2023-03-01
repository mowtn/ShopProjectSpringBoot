//package com.example.Shop.Config;
//
//import com.example.Shop.Sercurity.jwt.JwtEntryPoint;
//import com.example.Shop.Sercurity.jwt.JwtProvider;
//import com.example.Shop.Sercurity.jwt.JwtTokenFilter;
//import com.example.Shop.Sercurity.userprincal.UserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//kiểm tra tất cả trước khi gửi
//public class WebSecurityConfig {
//    @Autowired
//    UserDetailService userDetailService;
//    @Autowired
//    JwtEntryPoint jwtEntryPoint; //lớp dùng để kiểm tra xem token còn tồn tại hay không
//
//    @Bean
//    public JwtTokenFilter jwtTokenFilter(){
//        return new JwtTokenFilter();
//    }
//
////    @Bean
////    public void authenticationManagerBuilder(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////        authenticationManagerBuilder.userDetailsService(userDetailService)
////                .passwordEncoder(passwordEncoder());
////
////    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.cors().and().csrf().disable()
//                .authorizeHttpRequests((requests)-> requests
//                        .requestMatchers("/","home").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//
//                )
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtEntryPoint)//kiểm tra xem token đã chết chưa
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        httpSecurity
//                .formLogin((form)->form
//                        .loginProcessingUrl("/j_spring-security_check")
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/home")
//                        .failureUrl("/login?error=fail")
//                        .permitAll()
//                )
//                .logout((logout)->logout.permitAll());
//    return httpSecurity.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
//        return (web)->web.ignoring().requestMatchers("/image/**","/js/**","/css/**");
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
//
//
//}
