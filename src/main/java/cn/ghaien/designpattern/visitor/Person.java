package cn.ghaien.designpattern.visitor;

/**
 * @author guo.haien
 * @date 2018/10/18 13:26
 */
public interface Person {

    void accept(Action action);
}
