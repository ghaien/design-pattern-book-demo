package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class ConcreteBuilderB implements Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.addPart("partX");
    }

    @Override
    public void buildPartB() {
        product.addPart("partY");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
