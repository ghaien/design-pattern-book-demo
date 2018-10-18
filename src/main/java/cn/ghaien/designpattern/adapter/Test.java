package cn.ghaien.designpattern.adapter;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class Test {

    public static void main(String[] args) {
        Player ym = new CenterPlayer("姚明");
        ym.attack();
        ym.defense();

        Player bde = new ForwardPlayer("巴蒂尔");
        bde.attack();
        bde.defense();
    }
}
