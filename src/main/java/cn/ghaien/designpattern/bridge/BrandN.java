package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class BrandN extends Brand {
    @Override
    public void run() {
        System.out.print("品牌N ");
        soft.run();
    }
}
