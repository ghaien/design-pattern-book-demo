package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class ForenoonState implements State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println("当前时间：" + work.getHour() + "点 上午工作，精神百倍");
        } else {
            new NoonState().writeProgram(work);
        }
    }
}
