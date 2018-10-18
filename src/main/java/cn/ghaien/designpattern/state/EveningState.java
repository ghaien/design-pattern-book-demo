package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class EveningState implements State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 21) {
            System.out.println("当前时间：" + work.getHour() + "点 加班中，十分疲劳");
        } else {
            new SleepingState().writeProgram(work);
        }
    }
}
