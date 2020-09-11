package designMode.behavior.observer.old;

/**
 * @Author: long
 * @Date: 2020/8/31 16:45
 * @Title
 * @Description:
 */
public class CurrentConditions {

    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("temperature: " + temperature);
        System.out.println("pressure: " + pressure);
        System.out.println("humidity: " + humidity);
    }

}
