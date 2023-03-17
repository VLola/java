package com.example.Project_119.controllers;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class WebController {
//    CalculatorController calculatorController = new CalculatorController();
//    @GetMapping("/getFare")
//    public Trip getFare(@RequestParam(value = "distance") double distance, @RequestParam(value = "consumption") double consumption, @RequestParam(value = "price") double price) {
//        return calculatorController.getFare(distance, consumption, price);
//    }
//    @GetMapping("/getFuelConsumption")
//    public double getFuelConsumption(@RequestParam(value = "fuel") double fuel, @RequestParam(value = "distance") double distance) {
//        return calculatorController.getFuelConsumption(fuel, distance);
//    }
//    @GetMapping("/getHowMuchFuelIsEnough")
//    public double getHowMuchFuelIsEnough(@RequestParam(value = "consumption") double consumption, @RequestParam(value = "fuel") double fuel) {
//        return calculatorController.getHowMuchFuelIsEnough(consumption, fuel);
//    }
//    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getMoonPhase")
    public String getMoonPhase() {
        return Get();
    }
    @PostMapping("/postMoonPhase")
    public String postMoonPhase(@RequestParam(value = "date") String date) {

        return Post(LocalDateTime.parse(date));
    }
    public String Post(LocalDateTime now){
        if(now.getDayOfMonth()<=6) return "Waxing Crescent";
        else if(now.getDayOfMonth()==7) return "Full moon";
        else if(now.getDayOfMonth()>7 && now.getDayOfMonth()<=14) return "Waning moon";
        else if(now.getDayOfMonth()>15) return "Last quarter";
        else if(now.getDayOfMonth()>15 && now.getDayOfMonth()<=20) return "Waning month";
        else if(now.getDayOfMonth()==21) return "New moon";
        else if(now.getDayOfMonth()>21 && now.getDayOfMonth()<=27) return "Growing month";
        else if(now.getDayOfMonth()>27 && now.getDayOfMonth()<30) return "First quarter";
        else if(now.getDayOfMonth()>=30) return "First quarter";
        else return "Error";
    }
    public String Get(){
        LocalDateTime now = LocalDateTime.now();
        if(now.getDayOfMonth()<=6) return "Waxing Crescent";
        else if(now.getDayOfMonth()==7) return "Full moon";
        else if(now.getDayOfMonth()>7 && now.getDayOfMonth()<=14) return "Waning moon";
        else if(now.getDayOfMonth()>15) return "Last quarter";
        else if(now.getDayOfMonth()>15 && now.getDayOfMonth()<=20) return "Waning month";
        else if(now.getDayOfMonth()==21) return "New moon";
        else if(now.getDayOfMonth()>21 && now.getDayOfMonth()<=27) return "Growing month";
        else if(now.getDayOfMonth()>27 && now.getDayOfMonth()<30) return "First quarter";
        else if(now.getDayOfMonth()>=30) return "First quarter";
        else return "Error";
    }
}
