package cn.ghaien.designpattern.decoration;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的" + name);
    }
}
