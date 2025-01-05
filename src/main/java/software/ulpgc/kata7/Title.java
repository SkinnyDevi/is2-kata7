package software.ulpgc.kata7;

public record Title(String title, boolean isAdult, int startYear, int duration) {
    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", isAdult=" + isAdult +
                ", startYear=" + startYear +
                ", duration=" + duration +
                '}';
    }
}