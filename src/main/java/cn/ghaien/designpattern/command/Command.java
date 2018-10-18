package cn.ghaien.designpattern.command;

/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
