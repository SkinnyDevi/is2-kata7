package software.ulpgc.kata7.apps.swing;

import software.ulpgc.kata7.MapHistogramDataFieldBuilder;
import software.ulpgc.kata7.Title;
import software.ulpgc.kata7.TsvTitleReader;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        File file = new File("./title.basics.tsv");
//        List<Title> titles = new TsvTitleReader(file).read();
        List<Title> titles = getRandomTitles();

        titles.sort(Comparator.comparingInt(Title::startYear));
        Map<String, Integer> yearStats = getYearStats(titles);

        JFreeVerticalHistogramTitleStatisticDisplayer histogram = new JFreeVerticalHistogramTitleStatisticDisplayer(
                new MapHistogramDataFieldBuilder(yearStats),
                "Year Statistics Histogram"
        );
        HistogramMainFrame mainFrame = new HistogramMainFrame(histogram);
        mainFrame.display();
    }

    private static List<Title> getRandomTitles() {
        List<Title> randomTitles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            randomTitles.add(new Title(
                    "movie" + i,
                    i % 2 == 0,
                    random.nextInt(1980, 2024),
                    random.nextInt(30, 180)
            ));
        }

        return randomTitles;
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