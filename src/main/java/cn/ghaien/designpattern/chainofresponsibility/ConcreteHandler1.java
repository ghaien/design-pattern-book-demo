package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @Date 2018/10/12
 */
public class ConcreteHandler1 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println(this.getClass().getName() + " : " + request);
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
}
