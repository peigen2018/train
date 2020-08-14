package com.peigen.test.dp.observer.java;

public class Test {
    public static void main(String[] args) {
        WeatherData d = new WeatherData();

        CurrentConditionsDisplay c = new CurrentConditionsDisplay(d);
        d.setMeasurements(12,23,34);
    }
}
