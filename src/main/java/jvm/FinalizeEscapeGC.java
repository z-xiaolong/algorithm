package jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Author long
 * @Date 2020/6/14 20:06
 * @Title
 * @Description //TODO
 **/

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead!");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead!");
        }
    }

    public void isAlive() {
        System.out.println("I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed.");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
}
