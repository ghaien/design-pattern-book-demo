package cn.ghaien.concurrentactualcombat.chapter3;

/**
 * @author guo.haien
 * @date 2018/12/12 17:09
 */
public class Test {

    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.initialize();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    test.holder.setN(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    test.holder.assertSanity();
                }
            }
        }).start();
    }
}
