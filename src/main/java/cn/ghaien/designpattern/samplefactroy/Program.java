package cn.ghaien.designpattern.samplefactroy;

import java.util.Scanner;

/**
 * @author guo.haien
 * @Date 2018/7/11
 */
public class Program {

    public static void main(String[] args) {
        /* 方法一 */
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A：");
        Double numberA = scanner.nextDouble();
        System.out.println("请输入运算符号(+、-、*、/)：");
        String operate = scanner.next();
        System.out.println("请输入数字B：");
        Double numberB = scanner.nextDouble();
        switch (operate) {
            case "+" :
                System.out.println(numberA + numberB);
                break;
            case "-" :
                System.out.println(numberA - numberB);
                break;
            case "*" :
                System.out.println(numberA * numberB);
                break;
            case "/" :
                if (numberB.equals(0)) {
                    System.out.println("除数不能为0");
                } else {
                    System.out.println(numberA / numberB);
                }
                break;
            default:
                System.out.println("输入的运算符号有误");
        }*/

        /* 方法二 */
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A：");
        Double numberA = scanner.nextDouble();
        System.out.println("请输入运算符号(+、-、*、/)：");
        String operate = scanner.next();
        System.out.println("请输入数字B：");
        Double numberB = scanner.nextDouble();
        System.out.println(Operation.getResult(numberA, numberB, operate));*/

        /* 方法三 */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A：");
        Double numberA = scanner.nextDouble();
        System.out.println("请输入运算符号(+、-、*、/)：");
        String operate = scanner.next();
        System.out.println("请输入数字B：");
        Double numberB = scanner.nextDouble();
        IOperation operation = OperationFactory.create(operate);
        System.out.println(operation.getResult(numberA, numberB));
    }
}
