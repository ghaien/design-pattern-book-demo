package cn.ghaien.designpattern.templatemethod;

/**
 * @author guo.haien
 * @Date 2018/7/16
 */
public class TestPaperB extends TestPaper {

    @Override
    public String answer1() {
        return "c";
    }

    @Override
    public String answer2() {
        return "d";
    }

    @Override
    public String answer3() {
        return "e";
    }
}
