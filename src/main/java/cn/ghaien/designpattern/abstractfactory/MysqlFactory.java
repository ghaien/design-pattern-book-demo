package cn.ghaien.designpattern.abstractfactory;

import java.text.DecimalFormat;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class MysqlFactory implements Factory {

    @Override
    public IUser createUser() {
        return new MysqlUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new MysqlDepartment();
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0");
        System.out.println(df.format(1.512));
        System.out.println((double)(1L / 10L));
    }
}
