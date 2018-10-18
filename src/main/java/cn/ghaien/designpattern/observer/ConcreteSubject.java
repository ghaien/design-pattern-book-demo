package cn.ghaien.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private String subjectState;
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
