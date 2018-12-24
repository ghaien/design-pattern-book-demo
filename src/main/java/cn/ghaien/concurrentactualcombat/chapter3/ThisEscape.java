package cn.ghaien.concurrentactualcombat.chapter3;

/**
 * @author guo.haien
 * @date 2018/12/12 15:58
 */
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    interface EventSource {
        void registerListener(EventListener listener);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }

    public void doSomething(Event e) {

    }
}
