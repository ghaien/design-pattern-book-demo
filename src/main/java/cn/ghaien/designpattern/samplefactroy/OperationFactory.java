package cn.ghaien.designpattern.samplefactroy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class OperationFactory {

    public static IOperation create(String operate) {
        switch (operate) {
            case "+" :
                return new OperationAdd();
            case "-" :
                return new OperationSub();
            case "*" :
                return new OperationMul();
            case "/" :
                return new OperationDiv();
            default:
                throw new RuntimeException("运算符错误");
        }
    }
}
