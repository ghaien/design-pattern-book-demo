package cn.ghaien.designpattern.composite;

/**
 * @author guo.haien
 * @Date 2018/9/5
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(String idx);
}
