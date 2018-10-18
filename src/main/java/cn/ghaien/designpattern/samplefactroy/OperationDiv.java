package cn.ghaien.designpattern.samplefactroy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class OperationDiv implements IOperation {

    @Override
    public Double getResult(Double numberA, Double numberB) {
        if (numberB.equals(0)) {
            throw new RuntimeException("除数不能为0");
        }
        return numberA + numberB;
    }
}
