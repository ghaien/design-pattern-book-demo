package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class ConcreteBuilderA implements Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.addPart("partA");
    }

    @Override
    public void buildPartB() {
        product.addPart("partB");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
