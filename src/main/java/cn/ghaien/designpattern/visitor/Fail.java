package cn.ghaien.designpattern.visitor;

/**
 * @author guo.haien
 * @date 2018/10/18 13:33
 */
public class Fail implements Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println(man.getClass().getSimpleName() + this.getClass().getSimpleName() + "时，闷头喝酒，谁也不用劝。");
    }

    @Override
    public void getWomenConclusion(Women women) {
        System.out.println(women.getClass().getSimpleName() + this.getClass().getSimpleName() + "时，眼泪汪汪，谁也劝不了。");
    }
}
