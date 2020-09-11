package designMode.behavior.memento.games;

/**
 * @Author: long
 * @Date: 2020/9/1 15:29
 * @Title
 * @Description:
 */
public class GameRole {

    private int vit;
    private int def;

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    //创建memento
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    //从备忘录对象恢复gameRole状态
    public void recover(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    public void display() {
        System.out.println("当前游戏角色攻击力：" + this.vit + " 防御力：" + this.def);
    }
}
