package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @date 2018/10/12 11:26
 */
public class GeneralManager extends Manager {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println(request.getRequestType() + " : " + request.getRequestContent() + " 数量 " + request.getRequestNum() + " 被批准");
    }
}
