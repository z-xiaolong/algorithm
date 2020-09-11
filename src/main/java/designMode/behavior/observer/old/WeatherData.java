package designMode.behavior.observer.old;

/**
 * @Author: long
 * @Date: 2020/8/31 16:48
 * @Title
 * @Description:
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public float getTemperature() {
        return temperature;
    }


    public float getPressure() {
        return pressure;
    }


    public float getHumidity() {
        return humidity;
    }


    public void dataChange() {
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        dataChange();
    }
}
