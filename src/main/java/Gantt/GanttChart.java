package Gantt;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

import javax.swing.JFrame;
import java.text.SimpleDateFormat;

public class GanttChart extends JFrame {

    public GanttChart(String title) {
        super(title);

        JFreeChart chart = createGanttChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private JFreeChart createGanttChart() {
        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(createProjectTasks());

        JFreeChart chart = ChartFactory.createGanttChart(
                "Gantt Chart - Маркетплейс",  // Заголовок диаграммы
                "Этапы",                      // Метка по оси Y
                "Дата",                       // Метка по оси X
                dataset,                      // Данные
                true,                         // Включить легенду
                true,                         // Включить tooltips
                false                         // Не включать URL
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        return chart;
    }

    private TaskSeries createProjectTasks() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        TaskSeries series = new TaskSeries("Разработка маркетплейса");

        try {

            series.add(new Task("Анализ требований",
                    dateFormat.parse("01-11-2024"),
                    dateFormat.parse("15-12-2024")));


            series.add(new Task("Проектирование",
                    dateFormat.parse("16-12-2024"),
                    dateFormat.parse("15-02-2025")));


            series.add(new Task("Реализация",
                    dateFormat.parse("16-02-2025"),
                    dateFormat.parse("15-06-2025")));

            series.add(new Task("Тестирование",
                    dateFormat.parse("16-06-2025"),
                    dateFormat.parse("15-08-2025")));


            series.add(new Task("Внедрение",
                    dateFormat.parse("16-08-2025"),
                    dateFormat.parse("15-09-2025")));


            series.add(new Task("Поддержка",
                    dateFormat.parse("16-09-2025"),
                    dateFormat.parse("31-10-2025")));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return series;
    }

    public static void main(String[] args) {
        GanttChart chart = new GanttChart("Gantt Chart Example");
        chart.setSize(800, 600);
        // Центр окна
        chart.setLocationRelativeTo(null);
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}
