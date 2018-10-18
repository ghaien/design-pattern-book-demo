package cn.ghaien.designpattern.templatemethod;

/**
 * @author guo.haien
 * @Date 2018/7/16
 */
public class TestPaperA extends TestPaper {

    @Override
    public String answer1() {
        return "a";
    }

    @Override
    public String answer2() {
        return "b";
    }

    @Override
    public String answer3() {
        return "c";
    }
}
