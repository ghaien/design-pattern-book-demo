package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class OracleFactory implements Factory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new OracleDepartment();
    }
}
