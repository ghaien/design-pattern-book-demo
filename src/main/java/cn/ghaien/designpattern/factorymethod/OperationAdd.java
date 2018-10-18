package cn.ghaien.designpattern.factorymethod;

/**
 * @author guo.haien
 * @Date 2018/7/12
 */
public class OperationAdd implements Operation {

    @Override
    public Double getResult(Double numberA, Double numberB) {
        return numberA + numberB;
    }
}
