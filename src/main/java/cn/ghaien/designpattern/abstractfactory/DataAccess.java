package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class DataAccess {

    public static final String ORACLE = "Oracle";
    public static final String MYSQL = "Mysql";

    public static IUser createUser(String db) {
        switch (db) {
            case ORACLE:
                return new OracleUser();
            case MYSQL:
                return new MysqlUser();
            default:
                return null;
        }
    }

    public static IDepartment createDeparment(String db) {
        try {
            Class<? extends IDepartment> cla = (Class<? extends IDepartment>) Class.forName("cn.ghaien.designpattern.abstractfactory." + db + "Department");
            return cla.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("未找到类");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
