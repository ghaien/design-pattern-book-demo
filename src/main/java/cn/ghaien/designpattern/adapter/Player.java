package cn.ghaien.designpattern.adapter;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();

    public abstract void defense();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
