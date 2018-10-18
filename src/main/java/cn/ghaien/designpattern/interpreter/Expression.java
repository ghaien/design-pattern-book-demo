package cn.ghaien.designpattern.interpreter;

/**
 * @author guo.haien
 * @date 2018/10/18 11:29
 */
public abstract class Expression {

    public void Interpret(PlayContext playContext) {
        StringBuilder sb = new StringBuilder();
        String[] contexts = playContext.getText().split(" ");
        excute(contexts[0], new Double(contexts[1]));
        for (int i = 2; i < contexts.length; i++) {
            sb.append(contexts[i]);
            sb.append(" ");
        }
        playContext.setText(sb.toString());
    }

    public abstract void excute(String key, double value);
}
