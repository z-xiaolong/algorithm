package designMode.creation.builder;

/**
 * @Author: long
 * @Date: 2020/8/24 14:41
 * @Title
 * @Description:
 */
public abstract class HouseBuilder {

    protected House house = new House();

    public abstract void buildBasic();

    public abstract void buildWall();

    public abstract void buildRoof();

    public House buildHouse() {
        return house;
    }

}
