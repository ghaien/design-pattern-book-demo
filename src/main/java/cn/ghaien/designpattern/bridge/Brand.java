package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public abstract class Brand {

    protected Soft soft;

    public abstract void run();

    public Soft getSoft() {
        return soft;
    }

    public void setSoft(Soft soft) {
        this.soft = soft;
    }
}
