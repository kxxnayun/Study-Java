package Model;

public class Reservation {

    private int id;
    private String movieTitle;
    private String seat;

    public Reservation(int id, String movieTitle, String seat) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getSeat() {
        return seat;
    }
}
