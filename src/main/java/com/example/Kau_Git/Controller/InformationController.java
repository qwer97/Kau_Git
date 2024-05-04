package com.example.Kau_Git.Controller;

import com.example.Kau_Git.Entity.User;
import com.example.Kau_Git.Oauth.Login;
import com.example.Kau_Git.Oauth.SessionUser;
import com.example.Kau_Git.Service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class InformationController {

    private final MyPageService myPageService;

    @GetMapping("/MyInformation")
    public String MyInfo(@Login SessionUser user, Model model){
        if(user != null){
            User userInfo = myPageService.GetInformation(user.getEmail(), user.getName());
            if(userInfo != null){
                model.addAttribute("user", userInfo);
            } else {
                model.addAttribute("errorMessage", "사용자 정보를 찾을 수 없습니다.");
            }
        } else {
            return "redirect:/login";
        }

        return "MyInformation";
    }

    @PostMapping("/MyInformation")
    public String updateInformation(@Login SessionUser user,
                                    @RequestParam("address") String address, // 명시적으로 이름 지정 해줘야함. 지금은 4개 다 집어넣어야 바뀌는데 추후 개별수정 넣어야함.
                                    @RequestParam("religion") String religion,
                                    @RequestParam("nationality") String nationality,
                                    @RequestParam("gender") int gender){

        if(user != null){
            myPageService.SetInformation(user.getEmail(), address, religion, nationality, gender);
            return "redirect:/MyInformation"; // 정보 업데이트 후, 사용자 정보 페이지로 리다이렉션
        } else {
            return "redirect:/login";
        }
    }
}
