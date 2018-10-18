package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/8/23
 */
public class Work {

    private Integer hour;

    private Boolean isFinished = false;

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public void writeProgram() {
        /*if (hour < 12) {
            System.out.println("当前时间：" + hour + "点 上午工作，精神百倍");
        } else if (hour < 13) {
            System.out.println("当前时间：" + hour + "点 饿了，吃午饭，休息");
        } else if (hour < 17) {
            System.out.println("当前时间：" + hour + "点 下午状态还不错，继续努力");
        } else {
            if (isFinished) {
                System.out.println("当前时间：" + hour + "点 下班回家了");
            } else if (hour < 21) {
                System.out.println("当前时间：" + hour + "点 加班中，十分疲劳");
            } else {
                System.out.println("当前时间：" + hour + "点 不行了，睡着了");
            }
        }*/
        new ForenoonState().writeProgram(this);
    }
}

