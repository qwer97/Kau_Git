package com.example.Kau_Git.Oauth;

import com.example.Kau_Git.Oauth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

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
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                        .defaultSuccessUrl("/", true));
        return http.build();
    }

}


