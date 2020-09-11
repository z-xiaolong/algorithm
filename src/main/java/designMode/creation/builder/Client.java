package designMode.creation.builder;

/**
 * @Author: long
 * @Date: 2020/8/24 14:52
 * @Title
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        /*CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();*/
        StringBuilder builder = new StringBuilder("hello word");
        System.out.println(builder.toString());

    }
}
