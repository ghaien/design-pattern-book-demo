package cn.ghaien.designpattern.command;

/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public class BakeChickenWingCommand extends BakeCommand {

    public BakeChickenWingCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void execute() {
        barbecuer.BakeChickenWing();
    }

    @Override
    public String toString() {
        return "烤鸡翅";
    }
}
