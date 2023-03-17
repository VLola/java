package com.example.Project_119.controllers;
import com.example.Project_119.models.Trip;
import org.springframework.web.bind.annotation.*;


@RestController
public class WebController {
    CalculatorController calculatorController = new CalculatorController();
    @GetMapping("/getFare")
    public Trip getFare(@RequestParam(value = "distance") double distance, @RequestParam(value = "consumption") double consumption, @RequestParam(value = "price") double price) {
        return calculatorController.getFare(distance, consumption, price);
    }
    @GetMapping("/getFuelConsumption")
    public double getFuelConsumption(@RequestParam(value = "fuel") double fuel, @RequestParam(value = "distance") double distance) {
        return calculatorController.getFuelConsumption(fuel, distance);
    }
    @GetMapping("/getHowMuchFuelIsEnough")
    public double getHowMuchFuelIsEnough(@RequestParam(value = "consumption") double consumption, @RequestParam(value = "fuel") double fuel) {
        return calculatorController.getHowMuchFuelIsEnough(consumption, fuel);
    }
}
