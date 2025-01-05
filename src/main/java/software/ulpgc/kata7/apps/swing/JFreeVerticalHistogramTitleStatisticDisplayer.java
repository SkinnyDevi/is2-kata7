package software.ulpgc.kata7.apps.swing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import software.ulpgc.kata7.HistogramDataField;
import software.ulpgc.kata7.HistogramDataFieldBuilder;
import software.ulpgc.kata7.StatisticDisplayer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JFreeVerticalHistogramTitleStatisticDisplayer extends JPanel implements StatisticDisplayer {
    private final List<HistogramDataField> fields;
    private final String graphTitle;

    public JFreeVerticalHistogramTitleStatisticDisplayer(HistogramDataFieldBuilder fields, String graphTitle) {
        this.fields = fields.build();
        this.graphTitle = graphTitle;

        setLayout(new BorderLayout());
    }

    @Override
    public void display() {
        add(new ChartPanel(this.createChart(this.createDataset())));
    }

    private JFreeChart createChart(HistogramDataset dataset) {
        return ChartFactory.createHistogram(
                graphTitle + " | per 1000",
                "values",
                "count",
                dataset,
                PlotOrientation.VERTICAL,
                true, false, false
        );
    }

    private HistogramDataset createDataset() {
        HistogramDataset dataset = new HistogramDataset();
        double[] values = new double[this.fields.size()];
        for (int i = 0; i < this.fields.size(); i++)
            values[i] = this.fields.get(i).count();

        dataset.addSeries("x axis", values, this.fields.size());
        return dataset;
    }
}