package cn.ghaien.designpattern.visitor;

/**
 * @author guo.haien
 * @date 2018/10/18 13:28
 */
public class Women implements Person {

    @Override
    public void accept(Action action) {
        action.getWomenConclusion(this);
    }
}
