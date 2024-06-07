package com.example.Kau_Git.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class KeyWordTest {

    @Autowired
    private RestTemplateBuilder rb;

    @Autowired
    private KeywordSearchService ks;

    @Test
    public void ttest(){
        RestTemplate rt = rb.build();
        var info = ks.getInfo();

        for (var in : info) {
            System.out.println("주소: " + in.get("addr1"));
            System.out.println("이미지 URL: " + in.get("firstimage"));
            System.out.println("위도: " + in.get("mapx"));
            System.out.println("경도: " + in.get("mapy"));
            System.out.println("---------------------------");

        }


    }

}
