package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @Date 2018/10/12
 */
public class ConcreteHandler3 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 20) {
            System.out.println(this.getClass().getName() + " : " + request);
        } else {
            System.out.println("无法处理这种请求");
        }
    }
}
