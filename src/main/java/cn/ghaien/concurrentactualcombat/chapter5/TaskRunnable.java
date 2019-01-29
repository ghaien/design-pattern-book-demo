package cn.ghaien.concurrentactualcombat.chapter5;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author guo.haien
 * @date 2019/1/9 14:36
 */
public class TaskRunnable implements Runnable {

    private String[] strs = new String[10];

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                if (i >= 10) {
                    throw new Exception();
                }
                strs[i] = "i" + i;
                System.out.println(Thread.interrupted());
            } catch (Exception e) {
                System.out.println(Thread.interrupted());
                Thread.currentThread().interrupt();
//                e.printStackTrace();
            }

        }
    }
}

class Test {
    
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(10);
        System.out.println("test === start   " + LocalTime.now().toString());
        for (int i = 0; i < 100; i++) {
            es.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("test === end   " + LocalTime.now().toString());
    }
}
