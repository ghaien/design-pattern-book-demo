package cn.ghaien.designpattern.builder;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class ThinPeople implements People {
    @Override
    public void buildHead() {
        System.out.println("瘦子的头");
    }

    @Override
    public void buildBody() {
        System.out.println("瘦子的身体");
    }

    @Override
    public void buildLeftArm() {
        System.out.println("瘦子的左手");
    }

    @Override
    public void buildRightArm() {
        System.out.println("瘦子的右手");
    }

    @Override
    public void buildLeftFoot() {
        System.out.println("瘦子的左脚");
    }

    @Override
    public void buildRightFoot() {
        System.out.println("瘦子的右脚");
    }
}