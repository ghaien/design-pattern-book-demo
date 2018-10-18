package cn.ghaien.designpattern.visitor;

/**
 * @author guo.haien
 * @date 2018/10/18 13:31
 */
public class Success implements Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println(man.getClass().getSimpleName() + this.getClass().getSimpleName() + "时，背后多半有一个伟大的女人。");
    }

    @Override
    public void getWomenConclusion(Women women) {
        System.out.println(women.getClass().getSimpleName() + this.getClass().getSimpleName() + "时，背后大多有一个不成功的女人。");
    }
}
