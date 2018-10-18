package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseDiscount implements CaseSuper {

    private Double discount;

    public CaseDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public Double acceptCase(Double money) {
        return money * discount;
    }
}
