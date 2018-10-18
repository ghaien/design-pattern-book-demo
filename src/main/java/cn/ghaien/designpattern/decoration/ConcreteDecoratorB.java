package cn.ghaien.designpattern.decoration;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class ConcreteDecoratorB extends Decorator {

    @Override
    public void operation() {
        super.operation();
        behavior();
        System.out.println("ConcreteDecoratorB.operation();");
    }

    public void behavior() {
    }
}
