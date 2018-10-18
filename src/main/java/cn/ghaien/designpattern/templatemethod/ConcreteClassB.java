package cn.ghaien.designpattern.templatemethod;

/**
 * @author guo.haien
 * @Date 2018/7/16
 */
public class ConcreteClassB extends AbstractClass {

    @Override
    public void primitiveOperationA() {
        System.out.println("ConcreteClassB.primitiveOperationA();");
    }

    @Override
    public void primitiveOperationB() {
        System.out.println("ConcreteClassB.primitiveOperationB();");
    }
}
