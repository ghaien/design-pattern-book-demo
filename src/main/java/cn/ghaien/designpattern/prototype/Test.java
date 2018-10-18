package cn.ghaien.designpattern.prototype;

/**
 * @author guo.haien
 * @Date 2018/7/13
 */
public class Test {

    public static void main(String[] args) {
        /* 示例一 */
        /*Prototype prototype1 = new ConcretePrototype1("prototype1");
        Prototype prototype1_clone = prototype1.clonePrototype();
        System.out.println(prototype1 + ": " + prototype1.id);
        System.out.println(prototype1_clone + ": " + prototype1_clone.id);*/

        /* 示例二 */
        /*Resume daniao_1 = new Resume("大鸟");
        daniao_1.setPersonInfo("男", "29");
        daniao_1.setWorkPerience("1998-2000", "XX公司");

        Resume daniao_2 = (Resume) daniao_1.clone();
        daniao_2.setPersonInfo("男", "26");

        Resume daniao_3 = (Resume) daniao_1.clone();
        daniao_3.setWorkPerience("1998-2006", "YY公司");

        daniao_1.display();
        daniao_2.display();
        daniao_3.display();*/

        /* 示例三 */
        /*Resume_1 daniao_1 = new Resume_1("大鸟");
        daniao_1.setPersonInfo("男", "29");
        daniao_1.setWorkExperience("1998-2006", "XX公司");

        Resume_1 daniao_2 = (Resume_1) daniao_1.clone();
        daniao_2.setWorkExperience("1998-2006", "YY公司");

        Resume_1 daniao_3 = (Resume_1) daniao_1.clone();
        daniao_3.setWorkExperience("1998-2006", "ZZ公司");

        daniao_1.display();
        daniao_2.display();
        daniao_3.display();*/

        /* 示例四 */
        /*Resume_2 daniao_1 = new Resume_2("大鸟");
        daniao_1.setPersonInfo("男", "29");
        daniao_1.setWorkExperience("1998-2006", "XX公司");

        Resume_2 daniao_2 = (Resume_2) daniao_1.clone();
        daniao_2.setWorkExperience("1998-2006", "YY公司");

        Resume_2 daniao_3 = (Resume_2) daniao_1.clone();
        daniao_3.setWorkExperience("1998-2006", "ZZ公司");

        daniao_1.display();
        daniao_2.display();
        daniao_3.display();*/
    }
}
