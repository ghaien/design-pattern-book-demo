package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public interface Builder {

    void buildPartA();

    void buildPartB();

    Product getResult();
}
