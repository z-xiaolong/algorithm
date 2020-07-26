package leetcode.easy;


import java.util.LinkedList;

/**
 * @Author long
 * @Date 2020/7/22 11:07
 * @Title
 * @Description //TODO
 **/

public class AnimalShelf {


    LinkedList<int[]> animals;
    int Cat = 0;
    int Dog = 1;

    public AnimalShelf() {
        animals = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        animals.offer(animal);
    }

    public int[] dequeueAny() {
        if (animals.isEmpty())
            return new int[]{-1, -1};
        return animals.poll();
    }

    public int[] dequeueDog() {
        for (int[] animal : animals) {
            if (animal[1] == Dog) {
                int[] res = animal;
                animals.remove(animal);
                return res;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueCat() {
        for (int[] animal : animals) {
            if (animal[1] == Cat) {
                int[] res = animal;
                animals.remove(animal);
                return res;
            }
        }
        return new int[]{-1, -1};
    }

}
