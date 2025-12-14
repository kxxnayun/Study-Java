package Model;

import java.util.List;

public class MovieCardData {
    private String title;
    private String genre;
    private String rating;
    private int runningTime;
    private List<String> showtimes;
    private String posterColor;

    public MovieCardData(String title, String genre, String rating, int runningTime,
                         List<String> showtimes, String posterColor) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.runningTime = runningTime;
        this.showtimes = showtimes;
        this.posterColor = posterColor;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public List<String> getShowtimes() {
        return showtimes;
    }

    public String getPosterColor() {
        return posterColor;
    }

    public String getInfo() {
        return genre + " | " + rating + " | " + runningTime + "분";
    }
}
