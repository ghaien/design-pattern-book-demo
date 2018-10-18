package cn.ghaien.designpattern.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @Date 2018/9/12
 */
public class Waiter {

    private List<BakeCommand> bakeCommands = new ArrayList<>();

    public void setOrder(BakeCommand bakeCommand) {
        if (bakeCommand instanceof BakeChickenWingCommand) {
            System.out.println("服务员：鸡翅没有了，请点别的烧烤");
        } else {
            bakeCommands.add(bakeCommand);
            System.out.println("增加订单：" + bakeCommand + " 时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }

    public void noticeBarbecuer() {
        bakeCommands.forEach(BakeCommand::execute);
    }
}
