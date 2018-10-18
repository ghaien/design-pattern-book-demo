package cn.ghaien.designpattern.iterator;

/**
 * @author guo.haien
 * @Date 2018/9/7
 */
public class Test {

    public static void main(String[] args) {
        Aggregate<String> concreteAggregate = new ConcreteAggregate<>();
        concreteAggregate.putItem("大鸟");
        concreteAggregate.putItem("小菜");
        concreteAggregate.putItem("行李");
        concreteAggregate.putItem("老外");
        concreteAggregate.putItem("公交内部员工");
        concreteAggregate.putItem("小偷");

        Iterator iterator = new ConcreteIterator(concreteAggregate);
        Object item = iterator.first();
        while (!iterator.isDone()) {
            System.out.println(iterator.currentItem() + "请买车票");
            iterator.next();
        }
    }
}
