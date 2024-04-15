package com.example.Kau_Git.Controller;

import com.example.Kau_Git.Oauth.Login;
import com.example.Kau_Git.Oauth.OAuthAttributes;
import com.example.Kau_Git.Oauth.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @PostMapping("/login")
    public String login(@RequestParam("provider") String provider, Model model) {
        // provider에 따라 네이버 또는 구글 로그인 페이지로 리다이렉트
        String redirectUrl = "redirect:/";
        if ("naver".equals(provider)) {
            redirectUrl = "redirect:/oauth2/authorization/naver"; // 네이버 로그인 처리 URL
        } else if ("google".equals(provider)) {
            redirectUrl = "redirect:/oauth2/authorization/google"; // 구글 로그인 처리 URL
        }
        return redirectUrl;
    }

    @GetMapping("/")
    public String home(@Login SessionUser user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "home";
    }
}
