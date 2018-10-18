package cn.ghaien.designpattern.proxy;

/**
 * @author guo.haien
 * @Date 2018/7/12
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
