package cn.ghaien.concurrentactualcombat.chapter12;

/**
 * @author guo.haien
 * @date 2019/1/27 14:18
 */
public class BarrierTimer implements Runnable {

    private boolean started;

    private Long startTime, endTime;

    @Override
    public synchronized void run() {
        Long t = System.nanoTime();
        if (started) {
            endTime = t;
        } else {
            startTime = t;
            started = true;
        }
    }

    public synchronized void clear() {
        started = false;
    }

    public synchronized Long getTime() {
        return endTime - startTime;
    }
}
