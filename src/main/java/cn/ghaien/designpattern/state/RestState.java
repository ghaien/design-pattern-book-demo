package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class RestState implements State {

    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间：" + work.getHour() + "点 下班回家了");
    }
}
