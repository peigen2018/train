package com.peigen.test.dp.observer.my;

import com.peigen.test.dp.observer.my.inf.CurrentConditionsDisplay;

public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);


        weatherData.setMeasurements(12,21,33);
        weatherData.setMeasurements(122,21,333);

    }
}
