package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class MysqlUser implements IUser {

    @Override
    public void insertUser(User user) {
        System.out.println("mysql插入user");
    }

    @Override
    public User getUser(Integer id) {
        System.out.println("mysql获取user");
        return null;
    }
}
