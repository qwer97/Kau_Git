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


    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate rt;

    public GetFestivalService(RestTemplate rt){
        this.rt= rt;
    }


    public String callApiWithParameters(String mobileOs, String mobileApp, String eventStartDate, String serviceKey) {
        String baseUrl = apiUrl+"/searchFestival1"; // API의 기본 URL

        // UriComponentsBuilder를 사용하여 요청 URL 구성
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("MobileOs", "ETC")
                .queryParam("MobileApp", "HanZoom")
                .queryParam("eventStartDate", "20240418")
                .queryParam("serviceKey", apiKey)
                .toUriString();

        // API 호출 및 응답 반환
        return rt.getForObject(url, String.class);
    }



}
