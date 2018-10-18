package cn.ghaien.designpattern.bridge;

/**
 * @author guo.haien
 * @Date 2018/9/10
 */
public class AddressList implements Soft {
    @Override
    public void run() {
        System.out.println("打开通讯录");
    }
}
