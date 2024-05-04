package com.example.Kau_Git.Oauth;

import com.example.Kau_Git.Service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.*;
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig { // 시큐리티 환경 설정 클래스

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                /*.headers(headers -> headers
                        .contentSecurityPolicy("script-src 'self'; frame-ancestors 'self';"))
                */
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                        .requestMatchers("/api/v1/**").hasRole("USER")
                        .anyRequest().authenticated())
                .logout(logout -> logout
                                .logoutUrl("/logout") // 로그아웃 처리 URL 명시적 설정 (선택적)
                                .logoutSuccessUrl("/")
                                .invalidateHttpSession(true)
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                        .defaultSuccessUrl("/", true));
        return http.build();
    }

}



