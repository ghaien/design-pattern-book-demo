package cn.ghaien.designpattern.observer;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class Test {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(new ConcreteObserver(concreteSubject));
        concreteSubject.setSubjectState("stateA");
        concreteSubject.notifyObserver();

        Boss boss = new Boss();
        StockObserver stockObserver = new StockObserver("古皮袄", boss);
        NBAObserver nbaObserver = new NBAObserver("达兰秋", boss);
        boss.setSubjectState("BOSS回来了");
        boss.attach(stockObserver);
        boss.attach(nbaObserver);
        boss.detach(stockObserver);
        boss.notifyObserver();
    }
}
