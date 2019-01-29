package cn.ghaien.concurrentactualcombat.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author guo.haien
 * @date 2018/12/20 14:50
 */

public class Test {

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public static void main(String[] args) {
        Map<String, String> hMap = new HashMap<>();
        hMap.put(null, null);
        Map<String, String> cMap = new ConcurrentHashMap<>();
        cMap.put("key", "old value");
        cMap.put("key", "new value");

        int h1 = 0x31243248;
        // 0011 0001 0010 0100 0011 0010 0100 1000
        // 0000 0000 0000 0000 0011 0001 0010 0100
        // 0011 0001 0010 0100 0000 0011 0110 1100
        System.out.println(Integer.toString(h1 >>> 16, 16));
        System.out.println(Integer.toString(h1 ^ (h1 >>> 16), 16));
    }

}

