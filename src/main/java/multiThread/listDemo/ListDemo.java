package multiThread.listDemo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author long
 * @Date 2020/7/16 21:47
 * @Title
 * @Description //TODO
 **/

public class ListDemo {


    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
        list.add(0);
        list.get(0);
    }
}



interface a {
    void a();
}

interface b {
    void a();
    void b();
}

class C extends d implements a, b {



    @Override
    public void b() {

    }

    public static void main(String[] args) {
        C c = new C();
        c.a();
    }
}

class d{
    public void a(){
        System.out.println("c");
    }
}
