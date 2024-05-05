package com.example.Kau_Git.Controller;

import com.example.Kau_Git.Service.GetInfoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MapController {

    private final GetInfoService gs;

    @Autowired
    public MapController(GetInfoService gs){
        this.gs = gs;
    }
    @GetMapping("/map")
    public String map(){
        return "map";
    }

    @PostMapping("/getCoordinates")
    public ModelAndView getCoordinates(@RequestParam("lat") String latitude, @RequestParam("lng") String longitude){
        try {
            // 문자열을 적절한 숫자 형식으로 변환 (예시)

            ModelAndView mv = new ModelAndView();
            List<JSONObject> info = gs.getInfo(latitude, longitude);

            mv.addObject("info", info); // 가져온 정보를 뷰로 전달
            mv.setViewName("result");
            return mv;
        } catch (Exception e) {
            // 기타 예외 처리
            ModelAndView mv = new ModelAndView("map");
            return mv;
        }
    }




}
