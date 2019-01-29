package cn.ghaien.util.excel;

import java.util.List;

/**
 * 用于生成excel模板
 *
 * @author guo.haien
 * @date 2019/1/29 13:30
 */
public class TableTitle {
    /**
     * 表格内容
     */
    private String name;
    /**
     * 表格需要填充的键值
     */
    private String key;
    /**
     * 需要多占用几列
     */
    private int width;
    /**
     * 需要多占用几行
     */
    private int height;
    /**
     * 下一级表头列表
     */
    private List<TableTitle> leafs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<TableTitle> getLeafs() {
        return leafs;
    }

    public void setLeafs(List<TableTitle> leafs) {
        this.leafs = leafs;
    }
}
