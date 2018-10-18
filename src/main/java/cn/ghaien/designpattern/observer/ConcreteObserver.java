package cn.ghaien.designpattern.observer;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class ConcreteObserver implements Observer {

    private ConcreteSubject concreteSubject;

    public ConcreteObserver(ConcreteSubject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {
        System.out.println(concreteSubject.getSubjectState());
    }
}
