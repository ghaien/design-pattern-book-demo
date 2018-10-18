package cn.ghaien.designpattern.samplefactroy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class OperationMul implements IOperation {

    @Override
    public Double getResult(Double numberA, Double numberB) {
        return numberA * numberB;
    }
}
