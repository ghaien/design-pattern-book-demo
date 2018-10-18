package cn.ghaien.designpattern.decoration;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class Finery_2 extends Person {

    protected Person component;

    public void decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
