package cn.ghaien.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @Date 2018/8/10
 */
public class Product {

    private List<String> parts = new ArrayList<>();

    public void addPart(String part) {
        parts.add(part);
    }

    public void show() {
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
