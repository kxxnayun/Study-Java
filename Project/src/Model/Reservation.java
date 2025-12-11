package Model;

public class Reservation {
    private int id;
    private int movieId;
    private String seat;
    private String reservedAt;

    public Reservation(int id, int movieId, String seat, String reservedAt) {
        this.id = id;
        this.movieId = movieId;
        this.seat = seat;
        this.reservedAt = reservedAt;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getSeat() {
        return seat;
    }

    public String getReservedAt() {
        return reservedAt;
    }
}
