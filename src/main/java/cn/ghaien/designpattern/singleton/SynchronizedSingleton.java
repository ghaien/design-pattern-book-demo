package cn.ghaien.designpattern.singleton;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton singleton;

    private SynchronizedSingleton() {

    }

    public static SynchronizedSingleton getInstance() {
        if (singleton == null) {
            synchronized (SimpleSingleton.class) {
                if (singleton == null) {
                    singleton = new SynchronizedSingleton();
                }
            }
        }
        return singleton;
    }
}
