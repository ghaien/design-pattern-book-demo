package cn.ghaien.designpattern.command;

/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
