package cn.ghaien.designpattern.adapter;

/**
 * @author guo.haien
 * @Date 2018/9/3
 */
public class CenterPlayer extends Player {

    private AdapterCenterPlayer adapterCenterPlayer = new AdapterCenterPlayer();

    public CenterPlayer(String name) {
        super(name);
    }

    @Override
    public void attack() {
        adapterCenterPlayer.进攻(getName());
    }

    @Override
    public void defense() {
        adapterCenterPlayer.防守(getName());
    }
}
