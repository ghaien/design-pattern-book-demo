package cn.ghaien.designpattern.singleton;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class LazySingleton {

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        return InnerLazySingleton.lazySingleton;
    }

    private static class InnerLazySingleton {
        static LazySingleton lazySingleton = new LazySingleton();
    }
}
