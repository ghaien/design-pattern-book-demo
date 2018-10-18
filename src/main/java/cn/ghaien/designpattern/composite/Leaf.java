package cn.ghaien.designpattern.composite;

/**
 * @author guo.haien
 * @Date 2018/9/5
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("Cannot add to leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("Cannot remove from a leaf");
    }

    @Override
    public void display(String idx) {
        System.out.println(idx + "- Leaf " + name);
    }
}
