package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseIntegral implements CaseSuper {

    private Double moneyCondition;

    private Integer integralReturn;

    public CaseIntegral(Double moneyCondition, Integer integralReturn) {
        this.moneyCondition = moneyCondition;
        this.integralReturn = integralReturn;
    }

    @Override
    public Double acceptCase(Double money) {
        return (double) ((int) (money / moneyCondition) * integralReturn);
    }
}
