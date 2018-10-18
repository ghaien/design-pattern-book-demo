package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class ConcreteImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现B的方法执行");
    }
}
