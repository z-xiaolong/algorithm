package designMode.behavior.memento.games;

/**
 * @Author: long
 * @Date: 2020/9/1 15:29
 * @Title
 * @Description:
 */
public class Memento {

    private int vit;
    private int def;

    public Memento(int vit, int def) {
        this.vit = vit;
        this.def = def;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }
}
