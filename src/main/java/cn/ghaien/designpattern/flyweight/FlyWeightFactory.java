package cn.ghaien.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guo.haien
 * @date 2018/10/16 15:08
 */
public class FlyWeightFactory {

    private Map<String, FlyWeight> flyWeights = new HashMap<>();

    public FlyWeightFactory() {
        flyWeights.put("X", new ConcreteFlyWeight());
        flyWeights.put("Y", new ConcreteFlyWeight());
        flyWeights.put("Z", new ConcreteFlyWeight());
    }

    public FlyWeight getFlyWeight(String key) {
        return flyWeights.get(key);
    }
}
