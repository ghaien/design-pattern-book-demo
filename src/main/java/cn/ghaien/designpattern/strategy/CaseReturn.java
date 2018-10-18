package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseReturn implements CaseSuper {

    private Double moneyCondition;

    private Double moneyReturn;

    public CaseReturn(Double moneyCondition, Double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public Double acceptCase(Double money) {
        return money - ((int) (money / moneyCondition) * moneyReturn);
    }
}
