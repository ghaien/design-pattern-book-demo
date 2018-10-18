package cn.ghaien.designpattern.memento;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class RoleStateCaretaker {

    private RoleStateMemento roleStateMemento;

    public static void main(String[] args) {
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();

        Role role = new Role();
        role.show();

        roleStateCaretaker.setRoleStateMemento(role.saveState());

        role.killBoss();
        role.show();

        role.recoveryState(roleStateCaretaker.getRoleStateMemento());
        role.show();
    }

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}
