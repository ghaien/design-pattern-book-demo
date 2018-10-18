package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @date 2018/10/12 11:23
 */
public abstract class Manager {

    private String name;

    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public abstract void handleRequest(Request request);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getSuperior() {
        return superior;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }
}
