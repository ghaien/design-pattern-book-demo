package cn.ghaien.concurrentactualcombat.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guo.haien
 * @date 2018/12/24 16:32
 */
@RestController
@RequestMapping(value = {"/test"})
public class TestController {

    private static final int _1M = 1024 * 1024;

    @RequestMapping(value = {"/bug"}, method = RequestMethod.GET)
    public void createBug(Integer num) {
        for (int i = 0; i < num; i++) {
            byte[] mem = new byte[_1M];
        }
    }
}
