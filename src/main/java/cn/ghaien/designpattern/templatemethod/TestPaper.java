package cn.ghaien.designpattern.templatemethod;

/**
 * @author guo.haien
 * @Date 2018/7/16
 */
public abstract class TestPaper {

    public void testQuestion1() {
        System.out.println("1.杨过得到，后来给了郭靖，炼成倚天剑、屠龙刀的玄铁可能是[ ]");
        System.out.println("a.球墨铸铁 b.马口铁 c.高速合金钢 d.碳素纤维");
        System.out.println("答案：" + answer1());
    }

    public void testQuestion2() {
        System.out.println("2.杨过、程英、陆无双铲除了情花，造成[ ]");
        System.out.println("a.使这种植物不再害人 b.使一种珍稀物种灭绝 c.破坏了那个生物圈的生态平衡 d.造成该地区沙漠化");
        System.out.println("答案：" + answer2());
    }

    public void testQuestion3() {
        System.out.println("3.蓝凤凰致使华山师徒、桃谷六仙呕吐不止，如果你是大夫，会给他们开什么药[ ]");
        System.out.println("a.阿司匹林 b.牛黄解毒片 c.氟哌酸 d.让他们喝大量的牛奶 e.以上全不对");
        System.out.println("答案：" + answer3());
    }

    public abstract String answer1();

    public abstract String answer2();

    public abstract String answer3();
}
