package com.example.Kau_Git.Service;

import com.example.Kau_Git.Entity.User;
import com.example.Kau_Git.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MyPageServiceTest {

    @Autowired
    private MyPageService ms;

    @Autowired
    private UserRepository ur;

    @Test
    public void testGetInformation() {

        Optional<User> s1 = Optional.ofNullable(ms.GetInformation("mcrohmh@naver.com", "곽홍주"));

        System.out.println(s1.get().getEmail()+" "+s1.get().getName());
    }

    @Test
    public void testSetInformation() {

        ms.SetInformation("mcrohmh@naver.com","서울시 은평구 신사동","불교","한국",0);

    }
}
