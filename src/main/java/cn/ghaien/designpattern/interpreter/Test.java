package cn.ghaien.designpattern.interpreter;

/**
 * @author guo.haien
 * @date 2018/10/18 11:59
 */
public class Test {

    public static void main(String[] args) {
        String text = "O 1 A 0.5 B 3.5 E 4 O 3 E 1.5 F 0.5 G 1 O 2 C 3.5";
        PlayContext playContext = new PlayContext();
        playContext.setText(text);
        String[] strs;
        Expression expression;
        while ((strs = playContext.getText().split(" ")).length >= 2) {
            switch (strs[0]) {
                case "O":
                    expression = new Scale();
                    break;
                default:
                    expression = new Note();
            }
            expression.Interpret(playContext);
        }
    }
}
