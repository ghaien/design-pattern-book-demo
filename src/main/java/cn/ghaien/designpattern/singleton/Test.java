package cn.ghaien.designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();

        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(test.new MapOper(latch));
            t1.start();
        }

        System.out.println("thread already start, sleep for a while...");

        Thread.sleep(1000);
        latch.countDown();

    }

    public class MapOper implements Runnable {

        CountDownLatch latch ;

        public MapOper(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            SimpleSingleton simpleSingleton = null;
            try {
                simpleSingleton = SimpleSingleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(simpleSingleton);
        }
    }
}
