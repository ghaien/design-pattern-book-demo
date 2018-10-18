package cn.ghaien.designpattern.observer;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class StockObserver implements Observer {

    private String name;

    private Subject subject;

    public StockObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(subject.getSubjectState() + " " + name + " 关闭股票行情，继续工作! ");
    }
}
