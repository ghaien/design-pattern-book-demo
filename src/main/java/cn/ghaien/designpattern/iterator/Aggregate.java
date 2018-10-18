package cn.ghaien.designpattern.iterator;

/**
 * @author guo.haien
 * @Date 2018/9/7
 */
public interface Aggregate<T> {

    Iterator createIterator();

    int getCount();

    T getItem(int index);

    void putItem(T t);
}
