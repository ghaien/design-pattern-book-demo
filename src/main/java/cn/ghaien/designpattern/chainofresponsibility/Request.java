package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @date 2018/10/12 11:22
 */
public class Request {

    private String requestType;

    private String requestContent;

    private int requestNum;

    public Request() {
    }

    public Request(String requestType, String requestContent, int requestNum) {
        this.requestType = requestType;
        this.requestContent = requestContent;
        this.requestNum = requestNum;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(int requestNum) {
        this.requestNum = requestNum;
    }
}
