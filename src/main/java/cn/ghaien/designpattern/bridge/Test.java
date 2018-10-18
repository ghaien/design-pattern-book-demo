package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class Test {

    public static void main(String[] args) {
        Abstraction refined = new RefinedAbstraction();
        refined.setImplementor(new ConcreteImplementorA());
        refined.operation();

        refined.setImplementor(new ConcreteImplementorB());
        refined.operation();

        Brand brandM = new BrandM();
        brandM.setSoft(new Game());
        brandM.run();
        brandM.setSoft(new AddressList());
        brandM.run();

        Brand brandN = new BrandN();
        brandN.setSoft(new Game());
        brandN.run();
        brandN.setSoft(new AddressList());
        brandN.run();
    }
}
