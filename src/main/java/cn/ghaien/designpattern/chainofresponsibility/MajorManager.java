package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @date 2018/10/12 11:26
 */
public class MajorManager extends Manager {

    public MajorManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getRequestNum() <= 5) {
            System.out.println(request.getRequestType() + " : " + request.getRequestContent() + " 数量 " + request.getRequestNum() + " 被批准");
        } else {
            if (superior != null) {
                superior.handleRequest(request);
            }
        }
    }
}
