package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class OracleUser implements IUser {
    @Override
    public void insertUser(User user) {
        System.out.println("oracle插入user");
    }

    @Override
    public User getUser(Integer id) {
        System.out.println("oracle获取user");
        return null;
    }
}
