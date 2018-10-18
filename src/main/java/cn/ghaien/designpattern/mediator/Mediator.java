package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/12 14:32
 */
public interface Mediator {

    void send(String message, Colleague colleague);
}
