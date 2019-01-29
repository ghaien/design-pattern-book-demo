package cn.ghaien.util.chart;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Random;

import javafx.beans.binding.ObjectExpression;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;
import sun.misc.BASE64Encoder;

public class ChartUtils {

    private static String NO_DATA_MSG = "数据加载失败";
    private static Font FONT = new Font("宋体", Font.PLAIN, 12);
    public static Color[] CHART_COLORS = {
            new Color(31,129,188),
            new Color(92,92,97),
            new Color(144,237,125),
            new Color(255,188,117),
            new Color(153,158,255),
            new Color(255,117,153),
            new Color(253,236,109),
            new Color(128,133,232),
            new Color(158,90,102),
            new Color(255, 204, 102)
    };// 颜色

    static {
        setChartTheme();
    }

    public static void setChartTheme() {
        // 设置中文主题样式 解决乱码
        StandardChartTheme chartTheme = new StandardChartTheme("CN");
        // 设置标题字体
        chartTheme.setExtraLargeFont(FONT);
        // 设置图例的字体
        chartTheme.setRegularFont(FONT);
        // 设置轴向的字体
        chartTheme.setLargeFont(FONT);
        chartTheme.setSmallFont(FONT);
        chartTheme.setTitlePaint(new Color(51, 51, 51));
        chartTheme.setSubtitlePaint(new Color(85, 85, 85));

        chartTheme.setLegendBackgroundPaint(Color.WHITE);// 设置标注
        chartTheme.setLegendItemPaint(Color.BLACK);//
        chartTheme.setChartBackgroundPaint(Color.WHITE);
        // 绘制颜色绘制颜色.轮廓供应商
        // paintSequence,outlinePaintSequence,strokeSequence,outlineStrokeSequence,shapeSequence

        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[] { Color.WHITE };
        // 绘制器颜色源
        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(
                CHART_COLORS,
                CHART_COLORS,
                OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE
        );
        chartTheme.setDrawingSupplier(drawingSupplier);

        chartTheme.setPlotBackgroundPaint(Color.WHITE);// 绘制区域
        chartTheme.setPlotOutlinePaint(Color.WHITE);// 绘制区域外边框
        chartTheme.setLabelLinkPaint(new Color(8, 55, 114));// 链接标签颜色
        chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);

        chartTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
        chartTheme.setDomainGridlinePaint(new Color(192, 208, 224));// X坐标轴垂直网格颜色
        chartTheme.setRangeGridlinePaint(new Color(192, 192, 192));// Y坐标轴水平网格颜色

        chartTheme.setBaselinePaint(Color.WHITE);
        chartTheme.setCrosshairPaint(Color.BLUE);// 不确定含义
        chartTheme.setAxisLabelPaint(new Color(51, 51, 51));// 坐标轴标题文字颜色
        chartTheme.setTickLabelPaint(new Color(67, 67, 72));// 刻度数字
        chartTheme.setBarPainter(new StandardBarPainter());// 设置柱状图渲染
        chartTheme.setXYBarPainter(new StandardXYBarPainter());// XYBar 渲染

        chartTheme.setItemLabelPaint(Color.black);
        chartTheme.setThermometerPaint(Color.white);// 温度计

        ChartFactory.setChartTheme(chartTheme);
    }

    public static final String CHART_TYPE_BAR = "1";

    public static final String CHART_TYPE_LINE = "2";

    public static CategoryDataset testGetDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(22, "外联", "外联部");
        dataset.setValue(25, "宣传", "宣传部");
        dataset.setValue(12, "财务", "财务部");
        dataset.setValue(33, "技术", "技术部");
        return dataset;
    }

    public static PieDataset testPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("外联", 0);
        dataset.setValue("宣传", 0);
        dataset.setValue("财务", 0);
        dataset.setValue("技术", 0);
        return dataset;
    }

    public static JFreeChart getChart(CategoryDataset dataset, String title, String x, String y) {
        return getChart(dataset, title, x, y, CHART_TYPE_BAR);
    }

    public static final String DEFAULT_NO_DATA_MESSAGE = "无数据显示";

    public static final Font TITLE_FONT = new Font("宋体", Font.BOLD, 20);

    public static final Font LABEL_FONT = new Font("宋体", Font.BOLD, 10);

    public static final Font LEGEND_LABEL_FONT = new Font("宋体", Font.BOLD, 10);

    public static JFreeChart getPieChart(PieDataset dataset) {
//        StandardChartTheme sct = new StandardChartTheme("default");
//        sct.setRegularFont(new Font("宋体", Font.BOLD, 10));
//        sct.setLargeFont(new Font("宋体", Font.BOLD, 20));
//        sct.setExtraLargeFont(new Font("宋体", Font.PLAIN, 20));
//        sct.setPlotBackgroundPaint(Color.WHITE);
        JFreeChart jFreeChart = ChartFactory.createPieChart("测试图", dataset, true, false, Locale.SIMPLIFIED_CHINESE);
//        sct.apply(jFreeChart);
        return jFreeChart;
    }

    public static void main(String[] args) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            dataset.setValue("项目" + (i + 1), random.nextInt(100));
        }
        printJPG(getPieChart(dataset), "D:\\test.png");
    }

    /**
     * 获取折线加柱形图
     *
     * @param linedataset 折线图数据
     * @param bardataset  柱形图数据
     * @param title       标题
     * @param x           x轴名称
     * @param y1          y1轴名称
     * @param y2          y2轴名称
     * @return
     */
    public static JFreeChart getLineAndBarChart(CategoryDataset bardataset, CategoryDataset linedataset, String title, String x, String y1, String y2) {
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setRegularFont(new Font("宋体", Font.BOLD, 13));
        ChartFactory.setChartTheme(standardChartTheme);
        JFreeChart chart = ChartFactory.createLineChart(title,// 报表题目，字符串类型
                null, // 横轴
                null, // 纵轴
                null, // 数据集
                PlotOrientation.VERTICAL, // 图标方向垂直
                true, // 显示图例
                false, // 不用生成工具
                false // 不用生成URL地址
        );
        //默认折线图画图器
        LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
        //默认柱状图画图器
        BarRenderer barRenderer = new BarRenderer();
        //获取画板
        CategoryPlot plot = chart.getCategoryPlot();

        NumberAxis yAxis1 = new NumberAxis();
        yAxis1.setLabel(y1);
        yAxis1.setLabelFont(new Font("宋体", Font.BOLD, 13));
        NumberAxis yAxis2 = new NumberAxis();
        yAxis2.setLabel(y2);
        yAxis2.setLabelFont(new Font("宋体", Font.BOLD, 13));
        plot.setRangeAxis(0, yAxis1);
        plot.setRangeAxis(1, yAxis2);

        plot.setDataset(0, bardataset);
        plot.setRenderer(0, barRenderer);
        plot.mapDatasetToRangeAxis(0, 0);

        plot.setDataset(1, linedataset);
        plot.setRenderer(1, lineRenderer);
        plot.mapDatasetToRangeAxis(1, 1);
        //折线在柱面前面显示
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return chart;
    }

    public static JFreeChart getChart(CategoryDataset dataset, String title, String x, String y, String chartType) {
        // 此标题 ‘某社团各部门 ’将被后面的chart.setTitle的标题 ‘某社团各部门柱状图’ 覆盖
        JFreeChart chart;
        switch (chartType) {
            case CHART_TYPE_LINE:
                chart = ChartFactory.createLineChart(title, x, y, dataset, PlotOrientation.VERTICAL, true, true, false);
                ((LineAndShapeRenderer) ((CategoryPlot) chart.getPlot()).getRenderer()).setBaseShapesVisible(true);
                break;
            default:
                chart = ChartFactory.createBarChart(title, x, y, dataset, PlotOrientation.VERTICAL, true, true, false);
        }
        //抗锯齿
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
        // 设置柱状图 主标题的文字
        chart.setTitle(new TextTitle(title, new Font("宋体", Font.BOLD + Font.ITALIC, 20)));
        // 设置柱状图最下方说明的文字
        chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 12));
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis axis = plot.getDomainAxis();
        // 设置X轴坐标上标题的文字
        axis.setLabelFont(new Font("宋体", Font.BOLD, 22));
        // 设置X轴坐标上的文字，
        axis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
        int num = dataset.getColumnKeys().size() / 30 + 1;
        for (int i = 0; i < dataset.getColumnKeys().size(); i++) {
            if (i % num == 0) {
                axis.setTickLabelPaint(dataset.getColumnKey(i), Color.BLACK);
            } else {
                axis.setTickLabelPaint(dataset.getColumnKey(i), Color.WHITE);
            }
        }
        axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        ValueAxis valueAxis = plot.getRangeAxis();
        // 设置Y轴坐标上标题的文字
        valueAxis.setLabelFont(new Font("宋体", Font.BOLD, 12));
        // 设置Y轴坐标上的文字
        valueAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
        return chart;
    }

    public static String getImg(JFreeChart chart) {
        String img = null;
        byte[] picdata = null;
        BASE64Encoder encoder = new BASE64Encoder();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        try {
            ChartUtilities.writeChartAsJPEG(out, 1.0f, chart, 600, 450, null);
            in = new ByteArrayInputStream(out.toByteArray());
            picdata = new byte[in.available()];
            in.read(picdata);
            in.close();
            img = encoder.encode(picdata);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
            }
        }
        return img;
    }

    public static void printJPG(JFreeChart chart, String fileName) {
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream(fileName);
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 600, 450, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }
    }
}