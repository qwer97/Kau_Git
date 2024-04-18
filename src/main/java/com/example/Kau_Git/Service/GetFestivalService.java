package com.example.Kau_Git.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetFestivalService {



    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate rt;

    public GetFestivalService(RestTemplate rt){
        this.rt= rt;
    }


    public String getFestival() {
        String baseUrl ="https://apis.data.go.kr/B551011/KorService1/searchFestival1"; // API의 기본 URL

        // 필수 파라미터 값 설정
        String MobileOS = "etc"; // 예시 값
        String MobileApp = "Hanzoom"; // 예시 값
        String eventStartDate = "20240411"; // 예시 값 (YYYYMMDD 형식)
        String serviceKey = apiKey; // 실제 서비스 키로 교체해야 함

        // UriComponentsBuilder를 사용하여 요청 URL 구성
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("MobileOS", MobileOS)
                .queryParam("MobileApp", MobileApp)
                .queryParam("eventStartDate", eventStartDate)
                .queryParam("serviceKey", serviceKey)
                .toUriString();

        // API 호출 및 응답 반환 (실제 호출 코드는 여기에 추가)
        System.out.println("API 요청 URL: " + url);
        return rt.getForObject(url, String.class);
    }



}
