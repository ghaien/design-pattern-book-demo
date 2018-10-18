package cn.ghaien.designpattern.templatemethod;

/**
 * @author guo.haien
 * @Date 2018/7/16
 */
public class ConcreteClassA extends AbstractClass {

    @Override
    public void primitiveOperationA() {
        System.out.println("ConcreteClassA.primitiveOperationA();");
    }

    @Override
    public void primitiveOperationB() {
        System.out.println("ConcreteClassA.primitiveOperationB();");
    }
}
