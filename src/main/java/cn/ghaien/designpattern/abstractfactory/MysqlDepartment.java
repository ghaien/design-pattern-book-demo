package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class MysqlDepartment implements IDepartment {
    @Override
    public void insertDepartment(Department department) {
        System.out.println("mysql插入department");
    }

    @Override
    public Department getDepartment(Integer id) {
        System.out.println("mysql获取department");
        return null;
    }
}
