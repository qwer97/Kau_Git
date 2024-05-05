package com.example.Kau_Git.Service;


import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;


@SpringBootTest
public class GetTravelTest {
    @Autowired
    private RestTemplateBuilder rb;

    @Autowired
    private GetInfoService gi;

    @Test
    public void gttest() throws UnsupportedEncodingException, URISyntaxException, ParseException {
        RestTemplate rt = rb.build();

        //var info = gi.getInfo();
        /*
        for (var in : info) {
            System.out.println("제목: " + in.get("addr1"));
            System.out.println("주소: " + in.get("title"));
            System.out.println("이미지 URL: " + in.get("firstImage"));
            System.out.println("이미지 URL: " + in.get("firstImage2"));
            System.out.println("---------------------------");

        }

         */
    }

}
