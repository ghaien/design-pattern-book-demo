package cn.ghaien.designpattern.command;

/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public class BakeMuttonCommand extends BakeCommand {

    public BakeMuttonCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void execute() {
        barbecuer.BakeMutton();
    }

    @Override
    public String toString() {
        return "烤羊肉串";
    }
}
