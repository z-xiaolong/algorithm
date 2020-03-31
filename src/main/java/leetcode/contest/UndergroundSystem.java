package leetcode.contest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/29 11:44
 * @Title
 * @Description //TODO
 **/

public class UndergroundSystem {


    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        double i = undergroundSystem.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
        double j = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        double k = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        double l = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0

    }

    private Map<Integer, Person> persons;
    private Map<String, List<Trip>> tripsList;

    public UndergroundSystem() {
        persons = new HashMap<>();
        tripsList = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Person person = persons.getOrDefault(id, new Person(id));
        person.startTrip(stationName, t);
        persons.put(id, person);
    }

    public void checkOut(int id, String stationName, int t) {
        Person person = persons.getOrDefault(id, null);
        if (person == null) {
            return;
        }
        Trip cur = person.endTrip(stationName, t);
        List<Trip> list = tripsList.getOrDefault(cur.startStation + cur.endStation, new LinkedList<>());
        list.add(cur);
        tripsList.put(cur.startStation + cur.endStation, list);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Trip> list = tripsList.get(startStation + endStation);
        double sum = 0;
        for (Trip t : list) {
            sum += t.endTime - t.startTime;
        }
        return sum / list.size();
    }
}

class Trip {
    public int startTime;
    public String startStation;
    public boolean isFinish;
    public int endTime;
    public String endStation;

    public Trip(int startTime, String startStation) {
        this.startTime = startTime;
        this.startStation = startStation;
        this.isFinish = false;
    }
}

class Person {
    public int id;
    boolean isTrip = false;
    public Trip cur;

    public Person(int id) {
        this.id = id;
    }

    public void startTrip(String stationName, int startTime) {
        if (isTrip) {
            return;
        }
        isTrip = true;
        cur = new Trip(startTime, stationName);
    }

    public Trip endTrip(String stationName, int endTime) {
        cur.endStation = stationName;
        cur.endTime = endTime;
        cur.isFinish = true;
        isTrip = false;
        return cur;
    }
}
