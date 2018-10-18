package cn.ghaien.designpattern.abstractfactory;

import static cn.ghaien.designpattern.abstractfactory.DataAccess.*;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class Test {

    public static void main(String[] args) {
        /*Factory mysqlFactory = new MysqlFactory();
        IUser mysqlUser = mysqlFactory.createUser();
        mysqlUser.insertUser(new User());
        mysqlUser.getUser(1);

        Factory oracleFactory = new OracleFactory();
        IUser oracleUser = oracleFactory.createUser();
        oracleUser.insertUser(new User());
        oracleUser.getUser(1);*/

        /*String str = "你好(HHHS)";
        System.out.println(str.replaceAll("\\([a-zA-Z]+\\)", ""));*/

        IUser user = createUser(ORACLE);
        user.insertUser(new User());
        user.getUser(1);

        IDepartment department = createDeparment(MYSQL);
        department.insertDepartment(new Department());
        department.getDepartment(1);
    }
}
