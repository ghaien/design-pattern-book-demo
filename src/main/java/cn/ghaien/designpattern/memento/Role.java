package cn.ghaien.designpattern.memento;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class Role {

    private Integer vit;

    private Integer atk;

    private Integer def;

    public Role() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void killBoss() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public void show() {
        System.out.println("生命值：" + vit);
        System.out.println("攻击力：" + atk);
        System.out.println("防御力：" + def);
    }

    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    public void recoveryState(RoleStateMemento roleStateMemento) {
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    public Integer getVit() {
        return vit;
    }

    public void setVit(Integer vit) {
        this.vit = vit;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }
}
