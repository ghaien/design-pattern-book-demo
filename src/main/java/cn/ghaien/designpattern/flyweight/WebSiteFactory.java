package cn.ghaien.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guo.haien
 * @date 2018/10/16 15:32
 */
public class WebSiteFactory {

    private Map<String, WebSite> webSites = new HashMap<>();

    public WebSite getWebSite(String name) {
        if (webSites.get(name) == null) {
            webSites.put(name, new ConcreteWebSite(name));
        }
        return webSites.get(name);
    }

    public int getCount() {
        return webSites.size();
    }
}
