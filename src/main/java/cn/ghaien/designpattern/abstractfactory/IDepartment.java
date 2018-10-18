package cn.ghaien.designpattern.abstractfactory;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public interface IDepartment {

    void insertDepartment(Department department);

    Department getDepartment(Integer id);
}
