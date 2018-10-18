package cn.ghaien.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @Date 2018/9/5
 */
public class Composite extends Component {

    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void display(String idx) {
        System.out.println(idx + "- Composite " + name);
        components.forEach(component -> {
            String newIdx = idx + "--";
            component.display(newIdx);
        });
    }
}
