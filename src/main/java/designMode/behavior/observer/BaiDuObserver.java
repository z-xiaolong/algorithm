package designMode.behavior.observer;

/**
 * @Author: long
 * @Date: 2020/8/31 21:27
 * @Title
 * @Description:
 */
public class BaiDuObserver implements Observer {

    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("-------------百度网站------------");
        System.out.println("temperature: " + temperature);
        System.out.println("pressure: " + pressure);
        System.out.println("humidity: " + humidity);
    }
}
