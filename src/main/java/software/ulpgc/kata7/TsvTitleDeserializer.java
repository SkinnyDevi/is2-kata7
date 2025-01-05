package software.ulpgc.kata7;

public class TsvTitleDeserializer implements TitleDeserializer{
    @Override
    public Title deserializer(String data) {
        return deserialize(data.split("\t"));
    }

    private Title deserialize(String[] fields) {
        return new Title(
                fields[3],
                toBoolean(fields[4]),
                toInteger(fields[5]),
                toInteger(fields[7])
        );
    }

    private int toInteger(String field) {
        if (field.equals("\\N")) return 0;
        return Integer.parseInt(field);
    }

    private boolean toBoolean(String field) {
        return Boolean.parseBoolean(field);
    }
}