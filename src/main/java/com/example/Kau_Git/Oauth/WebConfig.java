package com.example.Kau_Git.Oauth;

import com.example.Kau_Git.Config.SessionUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final SessionUserInterceptor sessionUserInterceptor;

    @Autowired
    public WebConfig(SessionUserInterceptor sessionUserInterceptor) {
        this.sessionUserInterceptor = sessionUserInterceptor;
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionUserInterceptor).addPathPatterns("/**");
    }
}
