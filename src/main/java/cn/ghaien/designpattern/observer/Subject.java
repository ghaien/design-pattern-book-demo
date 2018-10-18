package cn.ghaien.designpattern.observer;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();

    String getSubjectState();
}
