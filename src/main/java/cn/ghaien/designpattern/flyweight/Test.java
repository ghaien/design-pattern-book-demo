package cn.ghaien.designpattern.flyweight;

/**
 * @author guo.haien
 * @date 2018/10/16 15:14
 */
public class Test {

    public static void main(String[] args) {
        /*FlyWeightFactory factory = new FlyWeightFactory();

        int num = 0;
        FlyWeight flyWeight1 = factory.getFlyWeight("X");
        FlyWeight flyWeight2 = factory.getFlyWeight("Y");
        FlyWeight flyWeight3 = factory.getFlyWeight("Z");
        flyWeight1.operation(++num);
        flyWeight2.operation(++num);
        flyWeight3.operation(++num);

        FlyWeight unsharedFlyWeight = new UnsharedConcreteFlyWeight();
        unsharedFlyWeight.operation(++num);*/

        WebSiteFactory wsf = new WebSiteFactory();
        WebSite fx = wsf.getWebSite("产品展示");
        fx.use(new User("fx"));
        WebSite fy = wsf.getWebSite("产品展示");
        fy.use(new User("fy"));
        WebSite fz = wsf.getWebSite("产品展示");
        fz.use(new User("fz"));
        WebSite fl = wsf.getWebSite("博客");
        fl.use(new User("fl"));
        WebSite fm = wsf.getWebSite("博客");
        fm.use(new User("fm"));
        WebSite fn = wsf.getWebSite("博客");
        fn.use(new User("fn"));

        System.out.println("网站分类总数：" + wsf.getCount());
    }
}
