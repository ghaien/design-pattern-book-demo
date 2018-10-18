package cn.ghaien.designpattern.decoration;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class ConcreteDecoratorA extends Decorator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void operation() {
        super.operation();
        setState("addState");
        System.out.println("ConcreteDecoratorA.operation();");
    }
}
