package com.example.Kau_Git.Service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Scanner;

@SpringBootTest
public class AreaTest {
    @Autowired
    private RestTemplateBuilder rb;

    @Autowired
    private AreaCodeService as;

    @Test
    public void ttest(){
        RestTemplate rt = rb.build();
        Scanner s = new Scanner(System.in);

        var info = as.getInfo(1);

        for(Map.Entry<String, String> entry : info.entrySet()){
            System.out.println("코드: " + entry.getKey() + ", 지역이름 " + entry.getValue());
        }
    }
}
