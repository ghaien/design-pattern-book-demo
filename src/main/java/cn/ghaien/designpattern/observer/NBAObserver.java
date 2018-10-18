package cn.ghaien.designpattern.observer;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class NBAObserver implements Observer {

    private String name;

    private Subject subject;

    public NBAObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(subject.getSubjectState() + " " + name + " 关闭NBA直播，继续工作! ");
    }
}
