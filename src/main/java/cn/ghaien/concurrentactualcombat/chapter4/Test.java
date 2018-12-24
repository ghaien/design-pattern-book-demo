package cn.ghaien.concurrentactualcombat.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @date 2018/12/20 11:14
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        /*ImprovedList*/
        /*List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(() -> new ImprovedList<>(strings).putIfAbsent("s" + j)).start();
        }
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(() -> new ImprovedList<>(strings).putIfAbsent("s" + j)).start();
        }
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(() -> new ImprovedList<>(strings).putIfAbsent("s" + j)).start();
        }
        Thread.sleep(5000);
        System.out.println(strings.size());*/

        List<String> strings = new ArrayList<>();
        ImprovedList<String> improvedList = new ImprovedList<>(strings);
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    improvedList.putIfAbsent("s" + j);
                }
            }).start();
        }
        Thread.sleep(5000);
        for (int i = 0; i < 1000; i++) {
            strings.add("s" + i);
        }
        Thread.sleep(5000);
        System.out.println(strings.size());

        /*ListHelper*/
        /*ListHelper<String> listHelper = new ListHelper<>();
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    listHelper.putIfAbsent("s" + j);
                }
            }).start();
        }
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    listHelper.putIfAbsent("s" + j);
                }
            }).start();
        }
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    listHelper.putIfAbsent("s" + j);
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(listHelper.list.size());*/
    }
}
