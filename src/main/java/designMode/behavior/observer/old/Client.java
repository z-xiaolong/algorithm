package designMode.behavior.observer.old;

/**
 * @Author: long
 * @Date: 2020/8/31 16:51
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();

        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(30, 150, 40);

        weatherData.setData(33, 150, 34);
    }
}
