package cn.ghaien.designpattern.samplefactroy;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class Operation {

    public static Double getResult(Double numberA, Double numberB, String operate) {
        switch (operate) {
            case "+" :
                return numberA + numberB;
            case "-" :
                return numberA - numberB;
            case "*" :
                return numberA * numberB;
            case "/" :
                if (numberB.equals(0)) {
                    throw new RuntimeException("除数不能为0");
                } else {
                    return numberA / numberB;
                }
            default:
                throw new RuntimeException("运算符错误");
        }
    }
}
