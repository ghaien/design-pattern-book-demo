package cn.ghaien.designpattern.singleton;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class HungrySingleton {

    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
