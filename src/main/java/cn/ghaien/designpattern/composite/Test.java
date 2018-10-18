package cn.ghaien.designpattern.composite;

/**
 * @author guo.haien
 * @Date 2018/9/5
 */
public class Test {

    public static void main(String[] args) {
        Component root = new Composite("ROOT");
        root.add(new Leaf("A"));
        root.add(new Leaf("B"));
        Component x = new Composite("X");
        Component y = new Composite("XY");
        y.add(new Leaf("XYA"));
        y.add(new Leaf("XYB"));
        x.add(new Leaf("XA"));
        x.add(new Leaf("XB"));
        x.add(y);
        root.add(x);
        root.add(new Leaf("C"));

        root.display("");

    }
}
