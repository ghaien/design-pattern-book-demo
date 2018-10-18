package cn.ghaien.designpattern.singleton;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class SimpleSingleton {

    private static SimpleSingleton singleton;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() throws InterruptedException {
        if (singleton == null) {
            Thread.sleep(1000);
            singleton = new SimpleSingleton();
        }
        return singleton;
    }
}
