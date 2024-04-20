package com.example.Kau_Git.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate rt(){

        RestTemplate rt = new RestTemplate();


        rt.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return rt;
    }

}


/*
    <addr1>인천광역시 중구 구읍로 63 (중산동)</addr1>
    <addr2></addr2>
    <booktour></booktour>
    <cat1>A02</cat1>
    <cat2>A0207</cat2>
    <cat3>A02070200</cat3>
    <contentid>2986679</contentid>
    <contenttypeid>15</contenttypeid>
    <createdtime>20230427173710</createdtime>
    <eventstartdate>20240505</eventstartdate>
    <eventenddate>20240505</eventenddate>
    <firstimage>http://tong.visitkorea.or.kr/cms/resource/86/3113986_image2_1.jpg</firstimage>
    <firstimage2>http://tong.visitkorea.or.kr/cms/resource/86/3113986_image3_1.jpg</firstimage2>
    <cpyrhtDivCd>Type3</cpyrhtDivCd>
    <mapx>126.5777264136</mapx>
    <mapy>37.4891227900</mapy>
    <mlevel>6</mlevel>
    <modifiedtime>20240418142841</modifiedtime>
    <areacode>2</areacode>
    <sigungucode>10</sigungucode>
    <tel>032-777-9891</tel>
    <title>가족의 달 어린이 축제</title> -> 여기서 addr1 과 first image, title 만 가져오면 된다.
 */