package cn.ghaien.designpattern.flyweight;

/**
 * @author guo.haien
 * @date 2018/10/16 15:10
 */
public class ConcreteFlyWeight implements FlyWeight {
    @Override
    public void operation(int num) {
        System.out.println("具体的FlyWeight：" + num);
    }
}
