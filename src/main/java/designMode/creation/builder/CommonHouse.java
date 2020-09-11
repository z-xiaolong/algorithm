package designMode.creation.builder;

/**
 * @Author: long
 * @Date: 2020/8/24 14:48
 * @Title
 * @Description:
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通地基");
    }

    @Override
    public void buildWall() {
        System.out.println("普通墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("普通屋顶");
    }
}
