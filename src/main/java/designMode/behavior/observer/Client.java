package designMode.behavior.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * @Author: long
 * @Date: 2020/8/31 21:25
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();
        BaiDuObserver baiDuObserver = new BaiDuObserver();
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiDuObserver);

        //weatherData.setData(15, 100, 30.3f);
        MySubject observable = new MySubject();
        MyObservable myObservable1 = new MyObservable();
        MyObservable myObservable2 = new MyObservable();
        MyObservable myObservable3 = new MyObservable();
        observable.addObserver(myObservable1);
        observable.addObserver(myObservable2);
        observable.addObserver(myObservable3);
        observable.setChanged();
        observable.notifyObservers("hello");

        observable.notifyObservers();

    }
}

class MyObservable implements Observer {
    private String value;

    public MyObservable() {
        this.value = "init";
    }

    @Override
    public void update(Observable o, Object arg) {
        this.value = (String) arg;
        System.out.println(this.value);
        System.out.println("oo");
    }
}

class MySubject extends Observable {
    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }
}


