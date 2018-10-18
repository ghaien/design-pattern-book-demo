package cn.ghaien.designpattern.chainofresponsibility;

/**
 * @author guo.haien
 * @date 2018/10/12
 */
public class Test {

    public static void main(String[] args) {
        /*Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        Random random = new Random(17);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            handler1.handleRequest(i);
        }
        */
        Manager common = new CommonManager("金里");
        Manager major = new MajorManager("宗建");
        Manager general = new GeneralManager("宗金丽");
        common.setSuperior(major);
        major.setSuperior(general);

        Request request1 = new Request("请假", "病假", 2);
        common.handleRequest(request1);

        Request request2 = new Request("请假", "休假", 5);
        common.handleRequest(request2);

        Request request3 = new Request("请假", "回家", 10);
        common.handleRequest(request3);

        Request request4 = new Request("加薪", "申请加薪", 500);
        common.handleRequest(request4);
    }
}
