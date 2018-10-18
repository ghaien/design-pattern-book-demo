package cn.ghaien.designpattern.factorymethod;

/**
 * @author guo.haien
 * @Date 2018/7/12
 */
public class SubFactory implements OperationFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
