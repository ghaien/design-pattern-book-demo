package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/16 14:02
 */
public class UnitedNationsSecurityCouncil implements UnitedNations {

    private Country country1;

    private Country country2;

    @Override
    public void declare(String message, Country country) {
        if (country == country1) {
            country2.getMessage(message);
        } else {
            country1.getMessage(message);
        }
    }

    public Country getCountry1() {
        return country1;
    }

    public void setCountry1(Country country1) {
        this.country1 = country1;
    }

    public Country getCountry2() {
        return country2;
    }

    public void setCountry2(Country country2) {
        this.country2 = country2;
    }
}
