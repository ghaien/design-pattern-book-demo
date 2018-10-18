package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public void operation() {
        implementor.operation();
    }

    public Implementor getImplementor() {
        return implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
}
