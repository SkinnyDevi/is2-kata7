package software.ulpgc.kata7.apps.console;

import software.ulpgc.kata7.MapHistogramDataFieldBuilder;
import software.ulpgc.kata7.Title;
import software.ulpgc.kata7.TsvTitleReader;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("./title.basics.tsv");
        List<Title> titles = new TsvTitleReader(file).read();
        titles.sort(Comparator.comparingInt(Title::startYear));
        Map<String, Integer> yearStats = getYearStats(titles);

        HorizontalHistogramTitleStatisticDisplayer histogram = new HorizontalHistogramTitleStatisticDisplayer(
                new MapHistogramDataFieldBuilder(yearStats),
                "Year Statistics Histogram"
        );
        histogram.display();
    }

    private static Map<String, Integer> getYearStats(List<Title> titles) {
        Map<String, Integer> stats = new LinkedHashMap<>();
        for (Title t: titles)
            stats.put(toString(t.startYear()), stats.getOrDefault(toString(t.startYear()), 0) + 1);

        return stats;
    }

    private static String toString(int i) {
        return String.valueOf(i);
    }
}