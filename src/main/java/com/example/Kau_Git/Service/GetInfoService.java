package com.example.Kau_Git.Service;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GetInfoService {
    private final RestTemplate rt;

    @Value("${api.key}")
    private String apiKey;

    public GetInfoService(RestTemplate rt) {
        this.rt = rt;
    }
    private static final String BASE_URL = "https://apis.data.go.kr/B551011/ForFriTourService/locationBasedList";

    public List<JSONObject> getInfo(String lat, String lng) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("serviceKey", apiKey)
                .queryParam("MobileOS", "etc")
                .queryParam("MobileApp", "hanzoom")
                .queryParam("mapX", lng) // 경도
                .queryParam("mapY", lat) // 위도 , 카카오 맵 api를 통해서 받아야 하고
                .queryParam("radius", "2000");

        String uriString = builder.build().encode().toUriString().replace("+", "%2B");
        uriString += "&_type=json";

        URI uri = URI.create(uriString);

        String response = rt.getForObject(uri, String.class);
        List<JSONObject> resultList = new ArrayList<>();



        try {
            JSONParser parser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
            JSONObject jsonResponse = (JSONObject) parser.parse(response);

            JSONObject responseObj = (JSONObject) jsonResponse.get("response");
            JSONObject body = (JSONObject) responseObj.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray itemArray = (JSONArray) items.get("item");

            for (Object item : itemArray) {
                JSONObject itemObj = (JSONObject) item;
                String addr1 = (String) itemObj.get("addr1");
                String title = (String) itemObj.get("title");
                String firstImage = (String) itemObj.get("firstimage");

                JSONObject TravelInfo= new JSONObject();
                TravelInfo.put("addr1", addr1);
                TravelInfo.put("title", title);
                TravelInfo.put("firstImage", firstImage);

                resultList.add(TravelInfo);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
