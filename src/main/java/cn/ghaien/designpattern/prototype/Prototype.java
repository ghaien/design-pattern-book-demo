package cn.ghaien.designpattern.prototype;

/**
 * @author guo.haien
 * @Date 2018/7/13
 */
public abstract class Prototype implements Cloneable {

    protected String id;

    public Prototype(String id) {
        this.id = id;
    }

    public abstract Prototype clonePrototype();
}
