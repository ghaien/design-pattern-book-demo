package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class Test {

    public static void main(String[] args) {
        Builder builderA = new ConcreteBuilderA();
        Director.Director(builderA);
        builderA.getResult().show();
        System.out.println("----------");
        Builder builderB = new ConcreteBuilderB();
        Director.Director(builderB);
        builderB.getResult().show();
        System.out.println("------------");
        new PeopleDirector(new FatPeople());
        System.out.println("----------");
        new PeopleDirector(new ThinPeople());
    }
}
