package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseRegister_1 {

    private Double total = 0d;

    private final Double[] DISCOUNT = {1d, 0.8d, 0.7d, 0.5d};

    private final String[] DISCOUNT_INFO = {"正常收费", "打八折", "打七折", "打五折"};

    private void btnOk(Double price, Double num, int discountIndex) {
        total += price * num * DISCOUNT[discountIndex];
        System.out.println("单价：" + price + " 数量：" + num + DISCOUNT_INFO[discountIndex] + " 合计：" + total);
    }

    public static void main(String[] args) {
        CaseRegister_1 caseRegister_1 = new CaseRegister_1();
        caseRegister_1.btnOk(13d, 2d, 1);
    }
}
