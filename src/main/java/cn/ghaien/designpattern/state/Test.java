package cn.ghaien.designpattern.state;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class Test {

    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(9);
        work.writeProgram();
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(14);
        work.writeProgram();
        work.setHour(17);
        work.writeProgram();

        work.setFinished(false);
//        work.setFinished(true);
        work.setHour(20);
        work.writeProgram();
        work.setHour(22);
        work.writeProgram();
    }
}
