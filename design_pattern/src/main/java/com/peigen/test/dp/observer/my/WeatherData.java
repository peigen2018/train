package com.peigen.test.dp.observer.my;

import com.peigen.test.dp.observer.my.inf.Observer;
import com.peigen.test.dp.observer.my.inf.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(0);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(this.temperature, this.humidity, this.pressure);
        }
    }
    public  void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(double temperature,double humidity, double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
