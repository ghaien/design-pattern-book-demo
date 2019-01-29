package cn.ghaien.util.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author guo.haien
 * @date 2019/1/29 13:23
 */
public class ExcelUtils {

    private final static String REPORT_TEMPLATE_PATH = "/templates/reportTemplate.xlsx";

    private final static String SIMPLE_PATTERN = "yyyy-MM-dd";

    private final static Logger LOG = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 将数据列表导出到模板excel中
     * 例如：模板excel中最后一行的某列值为$fieldName,
     * 那这一列从这行开始将被数据列表对象中的字段为fieldName的值依次填充。
     * (注：若数据列表对象中fieldName字段不存在则该列将被赋空值，不能使用Map来将key
     * 为fieldName的value值填充到指定列中)
     *
     * @param rte      模板信息
     * @param dataList 数据列表
     * @param response 响应对象
     * @param <T>      数据对象类型
     * @throws ExportExcelException excel导出异常
     */
    public static <T> void exportExcel(ReportTemplateEnum rte, List<T> dataList, HttpServletResponse response) throws ExportExcelException {
        try {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + new String(rte.getName().getBytes("GB2312"), "iso8859-1") + ".xls");
            exportByTemplate(rte.getSheet(), dataList, response.getOutputStream());
        } catch (IOException e) {
            throw new ExportExcelException("响应消息异常");
        }
    }

    /**
     * 将数据列表导出到通过指定表头信息列表生成的excel模板中
     * 步骤一：生成excel模板。表头信息对象的最后一级所占列只能是一个，
     * 最好字段key有值且与数据列表对象中能找到对应的字段名，
     * 否则导出后该列除了表头外其余都为空。
     * 步骤二：数据导出到生成的excel模板中。
     * 例如：模板excel中最后一行的某列值为$fieldName,
     * 那这一列从这行开始将被数据列表对象中的字段为fieldName的值依次填充。
     * (注：若数据列表对象中fieldName字段不存在则该列将被赋空值，不能使用Map来将key
     *
     * @param fileName excel文件名称
     * @param tts      表头信息列表
     * @param dataList 数据列表
     * @param response 响应对象
     * @param <T>      数据对象类型
     * @throws ExportExcelException excel导出异常
     * @see TableTitle
     */
    public static <T> void exportExcel(String fileName, List<TableTitle> tts, List<T> dataList, HttpServletResponse response) throws ExportExcelException {
        try {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + new String(fileName.getBytes("GB2312"), "iso8859-1") + ".xls");
            exportByTableTitleData(tts, dataList, response.getOutputStream());
        } catch (IOException e) {
            throw new ExportExcelException("响应消息异常");
        }
    }

    private static <T> void dataToSheet(XSSFSheet sheet, List<T> datas) {
        SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_PATTERN);
        if (datas != null && datas.size() > 0) {
            // 获取最后一行的总列数
            int rows = sheet.getPhysicalNumberOfRows();
            XSSFRow row = sheet.getRow(rows - 1);
            int cells = row.getPhysicalNumberOfCells();

            // 通过最后一行的值获取需要填充到该列的属性对象，将数据对象的属性和列号一一对应
            // 拥有MergedRegion注解的属性表示这列需要对重复的值进行合并
            Class cla = datas.get(0).getClass();
            Map<Integer, Field> fieldMap = new HashMap<>();
            List<Integer> mrCellIndexs = new ArrayList<>();
            for (int i = 0; i < cells; i++) {
                String cellValue = row.getCell(i).getStringCellValue();
                if (StringUtils.isEmpty(cellValue) || !cellValue.startsWith("$")) {
                    continue;
                } else {
                    cellValue = cellValue.replaceAll("\\$", "");
                }
                Field field;
                try {
                    field = cla.getDeclaredField(cellValue);
                } catch (NoSuchFieldException e) {
                    LOG.info("字段名为" + cellValue + "不存在");
                    continue;
                }
                field.setAccessible(true);

                if (field.getAnnotation(MergedRegion.class) != null) {
                    mrCellIndexs.add(i);
                }
                fieldMap.put(i, field);
            }

            XSSFCell cell;
            // 遍历数据列表，每条数据封装到一列中
            for (int i = 0; i < datas.size(); i++) {
                T data = datas.get(i);
                row = sheet.createRow(rows - 1 + i);
                // 遍历属性和列号，将数据对象的属性值填充到对应的列中
                for (Integer key : fieldMap.keySet()) {
                    cell = row.createCell(key);
                    Object fieldValue;
                    try {
                        fieldValue = fieldMap.get(key).get(data);
                        if (fieldValue == null) {
                            continue;
                        }
                    } catch (IllegalAccessException e) {
                        LOG.info("获取属性" + fieldMap.get(key).getName() + "的值异常");
                        continue;
                    }
                    if (fieldValue instanceof Double) {
                        cell.setCellValue((Double) fieldValue);
                    } else if (fieldValue instanceof Integer) {
                        cell.setCellValue((Integer) fieldValue);
                    } else if (fieldValue instanceof Long) {
                        cell.setCellValue((Long) fieldValue);
                    } else if (fieldValue instanceof String) {
                        cell.setCellValue((String) fieldValue);
                    } else if (fieldValue instanceof Boolean) {
                        cell.setCellValue((Boolean) fieldValue);
                    } else if (fieldValue instanceof Date) {
                        cell.setCellValue(sdf.format((Date) fieldValue));
                    } else {
                        LOG.info("导出实体的字段类型只能为数字、字符串和日期");
                    }
                }
            }
            // 遍历需要合并相同值的列号
            for (Integer cellIndex : mrCellIndexs) {
                int totalRows = sheet.getPhysicalNumberOfRows();
                // 合并开始行号
                int startRow = rows - 1;
                // 合并结束行号
                int endRow = rows - 1;
                // 遍历每一行的数据
                // 若满足条件：1、下一行的数据和该行数据一致；2、下一行为最后一行；3、开始行号不等于最后一行。则将startRow到最后一行合并
                // 若满足条件：1、下一行的数据和该行数据不一致；2、开始行号不等于结束行号。则将startRow到endRow行合并，和开始行号设置为下一行行号
                // 最后将结束行号设置为下一行行号
                for (int i = rows - 1; i < totalRows - 1; i++) {
                    String startCellValue = sheet.getRow(startRow).getCell(cellIndex).getStringCellValue();
                    String endCellValue = sheet.getRow(i + 1).getCell(cellIndex).getStringCellValue();
                    if (StringUtils.isEmpty(startCellValue) || !startCellValue.equals(endCellValue)) {
                        if (startRow != endRow) {
                            sheet.addMergedRegion(new CellRangeAddress(startRow, endRow, cellIndex, cellIndex));
                        }
                        startRow = i + 1;
                    } else if (i == totalRows - 2) {
                        if (startRow != totalRows - 1) {
                            sheet.addMergedRegion(new CellRangeAddress(startRow, totalRows - 1, cellIndex, cellIndex));
                        }
                    }
                    endRow = i + 1;
                }
            }
        }
    }

    private static <T> void exportByTemplate(String sheetName, List<T> datas, OutputStream os) throws ExportExcelException {
        XSSFWorkbook workbook;
        try {
            // 通过模板地址创建工作簿对象
            InputStream inputStream = ExcelUtils.class.getResourceAsStream(REPORT_TEMPLATE_PATH);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            throw new ExportExcelException("模板文件不存在");
        }
        // 移除sheetName以外的所有sheet
        Iterator<Sheet> sheets = workbook.sheetIterator();
        ArrayList<String> removeSheetNames = new ArrayList<>();
        while (sheets.hasNext()) {
            Sheet s = sheets.next();
            if (!s.getSheetName().equals(sheetName)) {
                removeSheetNames.add(s.getSheetName());
            }
        }
        for (String removeSheetName : removeSheetNames) {
            workbook.removeSheetAt(workbook.getSheetIndex(removeSheetName));
        }
        // 将数据更新到sheet中
        dataToSheet(workbook.getSheet(sheetName), datas);
        writeAndClose(os, workbook);
    }

    private static <T> void exportByTableTitleData(List<TableTitle> tts, List<T> datas, OutputStream os) throws ExportExcelException {
        XSSFWorkbook workbook = createTemplate(tts);
        dataToSheet(workbook.getSheetAt(0), datas);
        writeAndClose(os, workbook);
    }

    private static void writeAndClose(OutputStream os, XSSFWorkbook workbook) throws ExportExcelException {
        if (os != null) {
            try {
                // 输出和关闭流
                workbook.write(os);
                os.close();
            } catch (IOException e) {
                throw new ExportExcelException("文件下载失败");
            }
        }
    }

    private static XSSFWorkbook createTemplate(List<TableTitle> title) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        setTitle(workbook, sheet, title, 0, 0);

        int rows = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.createRow(rows);
        setColumnKey(row, title, 0);
        // 根据表格内容来自适应宽度
        for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
            sheet.autoSizeColumn(i, true);
        }
        return workbook;
    }

    private static void setTitle(XSSFWorkbook workbook, XSSFSheet sheet, List<TableTitle> tts, int startRow, int startCell) {
        for (TableTitle tt : tts) {
            XSSFRow row = sheet.getRow(startRow) == null ? sheet.createRow(startRow) : sheet.getRow(startRow);
            // 单元格样式
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            // 文字左右居中
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            // 文字上下居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // 下边框
            cellStyle.setBorderBottom(BorderStyle.THIN);
            // 左边框
            cellStyle.setBorderLeft(BorderStyle.THIN);
            // 右边框
            cellStyle.setBorderRight(BorderStyle.THIN);
            // 上边框
            cellStyle.setBorderTop(BorderStyle.THIN);
            // 字体样式
            Font fontStyle = workbook.createFont();
            // 加粗
            fontStyle.setBold(true);
            // 字体
            fontStyle.setFontName("宋体");
            // 大小
            fontStyle.setFontHeightInPoints((short) 11);
            // 将字体样式添加到单元格样式中
            cellStyle.setFont(fontStyle);
            XSSFCell cell = row.createCell(startCell);
            cell.setCellValue(tt.getName());
            cell.setCellStyle(cellStyle);
            if (tt.getWidth() > 0 || tt.getHeight() > 0) {
                CellRangeAddress cra = new CellRangeAddress(startRow, startRow + tt.getHeight(), startCell, startCell + tt.getWidth());
                sheet.addMergedRegion(cra);
                // 下边框
                RegionUtil.setBorderBottom(BorderStyle.THIN, cra, sheet);
                // 左边框
                RegionUtil.setBorderLeft(BorderStyle.THIN, cra, sheet);
                // 右边框
                RegionUtil.setBorderRight(BorderStyle.THIN, cra, sheet);
                // 上边框
                RegionUtil.setBorderTop(BorderStyle.THIN, cra, sheet);
            }
            if (tt.getLeafs() != null) {
                setTitle(workbook, sheet, tt.getLeafs(), startRow + tt.getHeight() + 1, startCell);
            }
            startCell = startCell + tt.getWidth() + 1;
        }
    }

    private static void setColumnKey(XSSFRow row, List<TableTitle> tts, int cellNum) {
        for (TableTitle tt : tts) {
            if (tt.getLeafs() != null) {
                setColumnKey(row, tt.getLeafs(), cellNum);
            } else {
                row.createCell(cellNum).setCellValue("$" + tt.getKey());
                cellNum++;
            }
        }
    }
}
