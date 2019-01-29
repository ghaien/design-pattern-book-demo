package cn.ghaien.concurrentactualcombat.chapter12;

import java.util.concurrent.Semaphore;

/**
 * @author guo.haien
 * @date 2019/1/27 13:49
 */
public class BoundedBuffer<E> {

    private final Semaphore avaliableItems, avaliableSpace;

    private final E[] items;

    private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity) {
        avaliableItems = new Semaphore(0);
        avaliableSpace = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public void put(E item) throws InterruptedException {
        avaliableSpace.acquire();
        insert(item);
        avaliableItems.release();
    }

    public E take() throws InterruptedException {
        avaliableItems.acquire();
        E item = extract();
        avaliableSpace.release();
        return item;
    }

    private synchronized void insert(E item) {
        int i = putPosition;
        items[i] = item;
        putPosition = (++i == items.length) ? 0 : i;
    }

    private synchronized E extract() {
        int i = takePosition;
        E item = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return item;
    }
}
