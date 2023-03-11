package com.example.Project_119.controllers;

import com.example.Project_119.models.Trip;

public class CalculatorController {
    //    Стоимость поездки
    public Trip getFare(double distance, double consumption, double price){

        Trip trip = new Trip();
        trip.setFuel(Math.round(distance / 100 * consumption));
        trip.setPrice(Math.round(distance / 100 * consumption * price));
        return trip;
    }
    //    Расход топлива
    public double getFuelConsumption(double fuel, double distance){
        return (Math.round(fuel / distance * 100 * 100) / 100.0);
    }
    //    Насколько хватит топлива
    public double getHowMuchFuelIsEnough(double consumption, double fuel){
        return Math.round(fuel / consumption * 100 * 100) / 100.0;
    }
}
