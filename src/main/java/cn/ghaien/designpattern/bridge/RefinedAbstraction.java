package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class RefinedAbstraction extends Abstraction {

    @Override
    public void operation() {
        System.out.print("Refined ");
        implementor.operation();
    }
}
