package cn.ghaien.designpattern.iterator;


/**
 * @author guo.haien
 * @Date 2018/9/7
 */
public class ConcreteIterator implements Iterator {

    private Aggregate aggregate;

    private int current = 0;

    public ConcreteIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        if (aggregate.getCount() > 0) {
            return aggregate.getItem(0);
        }
        return null;
    }

    @Override
    public Object next() {
        if (++current < aggregate.getCount()) {
            return aggregate.getItem(current);
        }
        return null;
    }

    @Override
    public boolean isDone() {
        return current >= aggregate.getCount();
    }

    @Override
    public Object currentItem() {
        if (aggregate.getCount() > current) {
            return aggregate.getItem(current);
        }
        return null;
    }
}
