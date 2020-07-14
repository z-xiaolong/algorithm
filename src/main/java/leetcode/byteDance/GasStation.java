package leetcode.byteDance;

/**
 * @Author long
 * @Date 2020/7/14 9:39
 * @Title 加油站
 * @Description //TODO
 **/

public class GasStation {

    public static void main(String[] args) {
        GasStation station = new GasStation();
        int[] gas = new int[]{2, 4};
        int[] cost = new int[]{3, 4};
        int s = station.gasStation(gas, cost);
        System.out.println(s);
    }


    public int gasStation(int[] gas, int[] cost) {
        int n = gas.length;
        int[] dif = new int[n];
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < n; i++) {
            dif[i] = gas[i] - cost[i];
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1;
        int start = 0;
        int max = dif[0];
        for (int i = 0; i < n; i++) {
            if (max < 0) {
                max = dif[i];

            } else {
                max += dif[i];

            }
        }

        return start;
    }

    public int gasStationII(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            if (gas[i] >= cost[i]) {
                int j = nextStation(gas, cost, i);
                if (j < i) return -1;
                if (j == i) return i;
                i = j + 1;
            } else {
                i++;
            }
        }
        return -1;
    }


    public int nextStation(int[] gas, int[] cost, int i) {
        int n = gas.length;
        int sum = gas[i] - cost[i];
        int j = i;
        while (sum >= 0) {
            j++;
            sum += gas[j % n] - cost[j % n];
            if (j - i >= n) return j % n;
        }
        return j % n;
    }

    public int gasStationI(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i] && isSatisfy(gas, cost, i))
                return i;
        }
        return -1;
    }

    public boolean isSatisfy(int[] gas, int[] cost, int index) {
        int sum = gas[index];
        int n = gas.length;
        int i = index;
        while (sum >= cost[i % n]) {
            sum -= cost[i % n];
            i++;
            sum += gas[i % n];
            if (i - index >= n) return true;
        }
        return false;
    }
}
