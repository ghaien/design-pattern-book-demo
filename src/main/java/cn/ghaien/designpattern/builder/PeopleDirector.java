package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class PeopleDirector {

    public PeopleDirector(People people) {
        people.buildHead();
        people.buildBody();
        people.buildLeftArm();
        people.buildRightArm();
        people.buildLeftFoot();
        people.buildRightFoot();
    }
}
