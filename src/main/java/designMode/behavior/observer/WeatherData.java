package designMode.behavior.observer;

import designMode.behavior.observer.old.CurrentConditions;

import java.util.ArrayList;

/**
 * @Author: long
 * @Date: 2020/8/31 17:06
 * @Title
 * @Description:
 */
public class WeatherData implements Subject {

    private float temperature;
    private float pressure;
    private float humidity;
    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this.temperature, this.pressure, this.humidity);
        }
    }


    public void dataChange() {
        notifyObserver();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        dataChange();
    }
}
