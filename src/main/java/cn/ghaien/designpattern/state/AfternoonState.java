package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class AfternoonState implements State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17) {
            System.out.println("当前时间：" + work.getHour() + "点 下午状态还不错，继续努力");
        } else {
            if (work.getFinished()) {
                new RestState().writeProgram(work);
            } else {
                new EveningState().writeProgram(work);
            }
        }
    }
}
