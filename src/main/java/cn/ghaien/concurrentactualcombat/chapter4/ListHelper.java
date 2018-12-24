package cn.ghaien.concurrentactualcombat.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author guo.haien
 * @date 2018/12/20 13:45
 */
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}
