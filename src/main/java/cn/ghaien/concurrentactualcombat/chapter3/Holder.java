package cn.ghaien.concurrentactualcombat.chapter3;

/**
 * @author guo.haien
 * @date 2018/12/14 14:04
 */
public class Holder {

    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("This statement is false.");
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public float poisson(float ld,int x){
        int xj=1;
        for(int i=1;i<=x;i++)
            xj=xj*i;
        return (float) (1/Math.pow(Math.E,ld)*Math.pow(ld,x)/xj);
    }

    public static void main(String[] args) {
        System.out.println(new Holder(1).poisson(1f, 36));
    }
}
