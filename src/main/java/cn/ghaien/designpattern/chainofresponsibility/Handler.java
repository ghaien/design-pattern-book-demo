package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @Date 2018/10/12
 */
public abstract class Handler {

    protected Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}
