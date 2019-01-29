package cn.ghaien.util.excel;

import java.lang.annotation.*;

/**
 * 判断列是否合并注解
 *
 * @author guo.haien
 * @date 2018/12/7 14:07
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MergedRegion {
}
