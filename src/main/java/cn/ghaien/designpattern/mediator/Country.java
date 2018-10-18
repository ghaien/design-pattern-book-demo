package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/12 14:57
 */
public abstract class Country {

    protected UnitedNations unitedNations;

    public Country(UnitedNations unitedNations) {
        this.unitedNations = unitedNations;
    }

    public abstract void declare(String messsage);

    public abstract void getMessage(String message);
}
