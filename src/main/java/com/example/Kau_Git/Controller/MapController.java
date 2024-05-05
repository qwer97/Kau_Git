package com.example.Kau_Git.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    @GetMapping("/map")
    public String map(){
        return "map";
    }

    @PostMapping("/getCoordinates")
    public ModelAndView getCoordinates(@RequestParam("lat") String latitude,@RequestParam("lng")String longitude){
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("latitude",latitude);
        mv.addObject("longitude",longitude);

        return mv;
    }



}
