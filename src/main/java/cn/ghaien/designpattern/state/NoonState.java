package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class NoonState implements State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println("当前时间：" + work.getHour() + "点 饿了，吃午饭，休息");
        } else {
            new AfternoonState().writeProgram(work);
        }
    }
}
