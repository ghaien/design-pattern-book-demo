package cn.ghaien.util.excel;

/**
 * excel模板名称
 *
 * @author guo.haien
 * @date 2019/1/29 13:36
 */
public enum ReportTemplateEnum {

    TESTEXCELEXPORT("测试excel模板导出工具","testExcelExport");

    private String name;

    private String sheet;

    ReportTemplateEnum(String name, String sheet) {
        this.name = name;
        this.sheet = sheet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }
}
