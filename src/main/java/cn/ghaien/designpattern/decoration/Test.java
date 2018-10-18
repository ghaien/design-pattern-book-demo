package cn.ghaien.designpattern.decoration;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class Test {

    public static void main(String[] args) {
        /* 方法一 */
        /*Person person = new Person("小菜");
        Finery tShirts = new TShirts();
        Finery bigTrouser = new BigTrouser();

        tShirts.show();
        bigTrouser.show();
        person.show();*/

        /* 装饰器模式模型 */
        /*ConcreteComponent cc = new ConcreteComponent();
        ConcreteDecoratorA cda = new ConcreteDecoratorA();
        ConcreteDecoratorB cdb = new ConcreteDecoratorB();

        cda.setComponent(cc);
        cdb.setComponent(cda);
        cdb.operation();*/

        /* 方法二 */
        Person person = new Person("小菜");
        TShirts_2 tShirts_2 = new TShirts_2();
        BigTrouser_2 bigTrouser_2 = new BigTrouser_2();
        tShirts_2.decorate(person);
        bigTrouser_2.decorate(tShirts_2);
        bigTrouser_2.show();
    }
}
