package cn.ghaien.concurrentactualcombat.demo;

import java.text.SimpleDateFormat;
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

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, j);
                    String str = sdf.format(calendar.getTime());
                    map.put(str, "");
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(map.size());
    }

}

