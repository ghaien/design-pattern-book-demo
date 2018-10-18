package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class Game implements Soft {
    @Override
    public void run() {
        System.out.println("运行游戏");
    }
}
