package cn.ghaien.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @Date 2018/9/7
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

    private List<T> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int index) {
        return items.get(index);
    }

    @Override
    public void putItem(T t) {
        items.add(t);
    }
}
