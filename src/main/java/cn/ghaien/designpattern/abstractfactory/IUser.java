package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public interface IUser {

    void insertUser(User user);

    User getUser(Integer id);
}
