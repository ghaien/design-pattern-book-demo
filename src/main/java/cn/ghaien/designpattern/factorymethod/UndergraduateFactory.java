package cn.ghaien.designpattern.factorymethod;

/**
 * @author guo.haien
 * @Date 2018/7/13
 */
public class UndergraduateFactory implements LeiFengFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
