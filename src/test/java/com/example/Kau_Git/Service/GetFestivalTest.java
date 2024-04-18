package com.example.Kau_Git.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GetFestivalTest {
    @Autowired
    private GetFestivalService gf;
    @Value("${api.key}")
    private String apiKey;
    @Autowired
    private RestTemplateBuilder rb;

    @Test
    public void gftest(){
        RestTemplate rt = rb.build();

        // FestivalService 클래스 내부에서 사용되는 RestTemplate 인스턴스를 테스트용으로 교체
        String result=gf.getFestival();


        System.out.println(result);
    }

}
