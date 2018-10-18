package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public interface Factory {

    IUser createUser();

    IDepartment createDepartment();
}
