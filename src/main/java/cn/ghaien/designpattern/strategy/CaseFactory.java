package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseFactory {

    public static CaseSuper create(Integer caseType) {
        switch (caseType) {
            case 0:
                return new CaseNormal();
            case 1:
                return new CaseDiscount(0.8d);
            case 2:
                return new CaseDiscount(0.7d);
            case 3:
                return new CaseDiscount(0.5d);
            case 4:
                return new CaseReturn(300d, 100d);
            case 5:
                return new CaseIntegral(100d, 10);
            default:
                throw new RuntimeException("选择的策略错误");
        }
    }
}
