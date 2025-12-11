package Model;

import java.util.ArrayList;
import java.util.List;

public class ReservationData {

    private int movieId;
    private String movieTitle;
    private String movieTime;
    private int peopleCount;
    private List<String> selectedSeats;

    public ReservationData() {
        this.selectedSeats = new ArrayList<>();
        this.peopleCount = 0;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public void addSeat(String seat) {
        if (!selectedSeats.contains(seat)) {
            selectedSeats.add(seat);
        }
    }

    public void removeSeat(String seat) {
        selectedSeats.remove(seat);
    }

    public void reset() {
        this.movieId = 0;
        this.movieTitle = null;
        this.movieTime = null;
        this.peopleCount = 0;
        this.selectedSeats.clear();
    }
}
