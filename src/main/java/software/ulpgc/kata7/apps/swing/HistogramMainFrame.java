package software.ulpgc.kata7.apps.swing;

import javax.swing.*;

public class HistogramMainFrame extends JFrame {
    private final JFreeVerticalHistogramTitleStatisticDisplayer histogram;

    public HistogramMainFrame(JFreeVerticalHistogramTitleStatisticDisplayer histogram) {
        this.histogram = histogram;

        setTitle("Histogram");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(histogram);
    }

    public void display() {
        this.histogram.display();
        this.setVisible(true);
    }
}