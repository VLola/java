package com.example.Project_120.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class WebController {
    @GetMapping("/getMoonPhase")
    public String getMoonPhase() {
        return Get(LocalDateTime.now());
    }
    @PostMapping("/postMoonPhase")
    public String postMoonPhase(@RequestParam(value = "date") String date) {
        return Get(LocalDateTime.parse(date));
    }
    public String Get(LocalDateTime now){
        if(now.getDayOfMonth()<=6) return "Waxing Crescent";
        else if(now.getDayOfMonth()>7 && now.getDayOfMonth()<=14) return "Waning moon";
        else if(now.getDayOfMonth()>15 && now.getDayOfMonth()<=21) return "Waning month";
        else if(now.getDayOfMonth()>22 && now.getDayOfMonth()<=28) return "Growing month";
        else if(now.getDayOfMonth()>28 && now.getDayOfMonth()<=30) return "First quarter";
        else if(now.getDayOfMonth()==31) return "First quarter";
        else if(now.getDayOfMonth()==22) return "New moon";
        else if(now.getDayOfMonth()==15) return "Last quarter";
        else if(now.getDayOfMonth()==7) return "Full moon";
        else return "Error";
    }
}
