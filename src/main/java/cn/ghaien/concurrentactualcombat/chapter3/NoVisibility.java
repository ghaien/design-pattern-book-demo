package cn.ghaien.concurrentactualcombat.chapter3;

/**
 * @author guo.haien
 * @date 2018/12/12 13:46
 */
public class NoVisibility {

    public static boolean ready;

    public static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
