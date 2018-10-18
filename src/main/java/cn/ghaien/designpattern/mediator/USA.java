package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/16 13:57
 */
public class USA extends Country {
    public USA(UnitedNations unitedNations) {
        super(unitedNations);
    }

    @Override
    public void declare(String messsage) {
        unitedNations.declare(messsage, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("美国获取对方信息：" + message);
    }
}
