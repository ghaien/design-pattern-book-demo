package cn.ghaien.designpattern.command;


/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public class Test {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new ConcreteCommand(new Receiver()));
        invoker.executeCommand();

        Barbecuer barbecuer = new Barbecuer();
        BakeCommand bakeCommand1 = new BakeChickenWingCommand(barbecuer);
        BakeCommand bakeCommand2 = new BakeMuttonCommand(barbecuer);
        BakeCommand bakeCommand3 = new BakeMuttonCommand(barbecuer);
        Waiter waiter = new Waiter();
        waiter.setOrder(bakeCommand1);
        waiter.setOrder(bakeCommand2);
        waiter.setOrder(bakeCommand3);
        waiter.noticeBarbecuer();
    }
}
