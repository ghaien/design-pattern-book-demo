package cn.ghaien.designpattern.iterator;

/**
 * @author guo.haien
 * @Date 2018/9/7
 */
public interface Iterator {

    Object first();

    Object next();

    boolean isDone();

    Object currentItem();
}
