package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/16 14:00
 */
public class Iraq extends Country {
    public Iraq(UnitedNations unitedNations) {
        super(unitedNations);
    }

    @Override
    public void declare(String messsage) {
        unitedNations.declare(messsage, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("伊拉克获得对方信息：" + message);
    }
}
