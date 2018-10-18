package cn.ghaien.designpattern.interpreter;

/**
 * @author guo.haien
 * @date 2018/10/18 11:43
 */
public class Note extends Expression {

    @Override
    public void excute(String key, double value) {
        String note = "";
        switch (key) {
            case "A":
                note = "1";
                break;
            case "B":
                note = "2";
                break;
            case "C":
                note = "3";
                break;
            case "D":
                note = "4";
                break;
            case "E":
                note = "5";
                break;
            case "F":
                note = "6";
                break;
            case "G":
                note = "7";
                break;
        }
        System.out.print(note + " ");
    }
}
