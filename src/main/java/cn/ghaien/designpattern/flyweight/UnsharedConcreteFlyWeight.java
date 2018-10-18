package cn.ghaien.designpattern.flyweight;

/**
 * @author guo.haien
 * @date 2018/10/16 15:11
 */
public class UnsharedConcreteFlyWeight implements FlyWeight {
    @Override
    public void operation(int num) {
        System.out.println("不共享的FlyWeight：" + num);
    }
}
