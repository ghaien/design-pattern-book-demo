package cn.ghaien.designpattern.templatemethod;

/**
 * @author guo.haien
 * @Date 2018/7/16
 */
public abstract class AbstractClass {

    public void templateMethod() {
        primitiveOperationA();
        primitiveOperationB();
        System.out.println("AbstractClass.templateMethod();");
    }

    public abstract void primitiveOperationA();

    public abstract void primitiveOperationB();
}
