package cn.ghaien.concurrentactualcombat.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @date 2018/12/20 9:22
 */
public class TestSynchronized {

    public int number;

    public TestSynchronized testSynchronized;

    public TestSynchronized(TestSynchronized testSynchronized) {
        this.testSynchronized = testSynchronized;
    }

    public synchronized void addNumber() {
        testSynchronized.number++;
    }

    public static void main(String[] args) throws InterruptedException {
        TestSynchronized ts = new TestSynchronized(null);
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new TestSynchronized(ts).addNumber();
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(ts.number);
    }
}
