package cn.ghaien.designpattern.command;

/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public abstract class BakeCommand {

    protected Barbecuer barbecuer;

    public BakeCommand(Barbecuer barbecuer) {
        this.barbecuer = barbecuer;
    }

    public abstract void execute();
}
