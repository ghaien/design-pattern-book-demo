package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseRegister_2 {

    private Double total = 0d;

    private Integer integral = 0;

    private final Double[] DISCOUNT = {1d, 0.8d, 0.7d, 0.5d};

    private final String[] DISCOUNT_INFO = {"正常收费", "打八折", "打七折", "打五折", "满300减100", "满100积分10点"};

    private void btnOk(Double price, Double num, int discountIndex) {
        total += CaseFactory.create(discountIndex).acceptCase(price * num);
        System.out.println("单价：" + price + " 数量：" + num + " " + DISCOUNT_INFO[discountIndex] + " 合计：" + total);
    }

    public static void main(String[] args) {
        CaseRegister_2 caseRegister_1 = new CaseRegister_2();
        caseRegister_1.btnOk(100d, 8d, 1);
        caseRegister_1.btnOk(26d, 4d, 2);
        caseRegister_1.setTotal(CaseFactory.create(4).acceptCase(caseRegister_1.getTotal()));
        System.out.println("满返后合计：" + caseRegister_1.getTotal());
        caseRegister_1.setIntegral(CaseFactory.create(5).acceptCase(caseRegister_1.getTotal()).intValue());
        System.out.println("积分：" + caseRegister_1.getIntegral());
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
