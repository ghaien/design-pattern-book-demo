package cn.ghaien.designpattern.prototype;

/**
 * @author guo.haien
 * @Date 2018/7/13
 */
public class ConcretePrototype2 extends Prototype {

    public ConcretePrototype2(String id) {
        super(id);
    }

    @Override
    public Prototype clonePrototype() {
        try {
            return (ConcretePrototype2) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
