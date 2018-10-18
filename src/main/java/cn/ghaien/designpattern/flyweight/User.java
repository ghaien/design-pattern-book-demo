package cn.ghaien.designpattern.flyweight;

/**
 * @author guo.haien
 * @date 2018/10/16 15:26
 */
public class User {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
