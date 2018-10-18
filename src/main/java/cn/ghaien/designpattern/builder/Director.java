package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class Director {

    public static void Director(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
