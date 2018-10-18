package cn.ghaien.designpattern.facade;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class Test {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
