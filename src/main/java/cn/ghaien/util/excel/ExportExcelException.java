package cn.ghaien.util.excel;

/**
 * excel处理相关异常
 *
 * @author guo.haien
 * @date 2018/12/7 14:10
 */
public class ExportExcelException extends Exception {

    private static final long serialVersionUID = -380461868451227481L;

    public ExportExcelException() {
        super();
    }

    public ExportExcelException(String message) {
        super(message);
    }
}