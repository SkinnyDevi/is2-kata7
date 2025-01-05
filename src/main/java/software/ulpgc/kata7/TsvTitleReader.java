package software.ulpgc.kata7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader {
    private final File file;

    public TsvTitleReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            return readWith(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        List<Title> results = new ArrayList<>();
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            results.add(deserializer.deserializer(line));
        }

        return results;
    }
}