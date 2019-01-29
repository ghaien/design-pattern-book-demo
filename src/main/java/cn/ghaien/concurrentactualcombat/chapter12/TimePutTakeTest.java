package cn.ghaien.concurrentactualcombat.chapter12;

import org.springframework.util.Assert;

import java.sql.Time;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guo.haien
 * @date 2019/1/27 14:03
 */
public class TimePutTakeTest {

    private final AtomicInteger putSum = new AtomicInteger(0);

    private final AtomicInteger takeSum = new AtomicInteger(0);

    private final CyclicBarrier barrier;

    private final BoundedBuffer<Integer> bb;

    private final int nTrials, nPairs;

    private final BarrierTimer timer = new BarrierTimer();

    private final static ExecutorService es = Executors.newCachedThreadPool();

    public TimePutTakeTest(int capacity, int nPairs, int nTrials) {
        this.bb = new BoundedBuffer<>(capacity);
        this.nPairs = nPairs;
        this.nTrials = nTrials;
        this.barrier = new CyclicBarrier(nPairs * 2 + 1, timer);
    }

    public void test() {
        try {
            timer.clear();
            for (int i = 0; i < nPairs; i++) {
                es.execute(new Producer());
                es.execute(new Consumer());
            }
            barrier.await();
            barrier.await();
            long nsPerItem = timer.getTime() / (nPairs * (long) nTrials);
            System.out.print("Throughput: " + nsPerItem + "ns/item");
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void assertEquals(Object o1, Object o2) throws Exception {
        if (o1 == null || !o1.equals(o2)) {
            throw new Exception();
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                int seed = this.hashCode() ^ (int) System.nanoTime();
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; i--) {
                    bb.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; i--) {
                    sum += bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int xorShift(int y) {
        y ^= y << 6;
        y ^= y >> 21;
        y ^= y << 7;
        return y;
    }

    public static void main(String[] args) throws Exception {
        int nTrials = 100000;
        for (int cap = 100; cap <= 1000; cap *= 10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128 ; pairs *= 2) {
                TimePutTakeTest t = new TimePutTakeTest(cap, pairs, nTrials);
                System.out.print("Pairs: " + pairs + "\t");
                t.test();
                System.out.print("\t");
                Thread.sleep(1000);
                t.test();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        es.shutdown();
    }
}
