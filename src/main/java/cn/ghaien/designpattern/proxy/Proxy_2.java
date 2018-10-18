package cn.ghaien.designpattern.proxy;

/**
 * @author guo.haien
 * @Date 2018/7/12
 */
public class Proxy_2 implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
