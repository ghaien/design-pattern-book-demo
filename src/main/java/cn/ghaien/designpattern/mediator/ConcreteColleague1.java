package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/12 14:37
 */
public class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        mediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println("同事 1 得到的消息: " + message);
    }
}
