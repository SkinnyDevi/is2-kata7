package software.ulpgc.kata7.apps.console;

import software.ulpgc.kata7.HistogramDataField;
import software.ulpgc.kata7.HistogramDataFieldBuilder;
import software.ulpgc.kata7.StatisticDisplayer;

import java.util.List;

public class HorizontalHistogramTitleStatisticDisplayer implements StatisticDisplayer {
    private final List<HistogramDataField> fields;
    private final String graphTitle;

    public HorizontalHistogramTitleStatisticDisplayer(HistogramDataFieldBuilder fields, String graphTitle) {
        this.fields = fields.build();
        this.graphTitle = graphTitle;
    }

    @Override
    public void display() {
        System.out.println("\n" + graphTitle + " | per 1000" + "\n");

        for (HistogramDataField field: fields)
            System.out.println(field.name() + ": " + "-".repeat((field.count() - 1) / 1000) + ">");
    }
}