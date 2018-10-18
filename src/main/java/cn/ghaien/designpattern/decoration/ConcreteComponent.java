package cn.ghaien.designpattern.decoration;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent.operation();");
    }
}
