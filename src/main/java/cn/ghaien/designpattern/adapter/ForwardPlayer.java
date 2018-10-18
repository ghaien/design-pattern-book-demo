package cn.ghaien.designpattern.adapter;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class ForwardPlayer extends Player {

    public ForwardPlayer(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(getName() + "进攻");
    }

    @Override
    public void defense() {
        System.out.println(getName() + "防守");
    }
}
