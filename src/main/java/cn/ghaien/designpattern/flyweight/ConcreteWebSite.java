package cn.ghaien.designpattern.flyweight;

/**
 * @author guo.haien
 * @date 2018/10/16 15:30
 */
public class ConcreteWebSite implements WebSite {

    private String name;

    public ConcreteWebSite(String name) {
        this.name = name;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + name + " 用户：" + user.getUserName());
    }
}
