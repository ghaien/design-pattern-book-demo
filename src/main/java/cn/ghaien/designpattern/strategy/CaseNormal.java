package cn.ghaien.designpattern.strategy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class CaseNormal implements CaseSuper {

    @Override
    public Double acceptCase(Double money) {
        return money;
    }
}
