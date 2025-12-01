package Model;

import java.util.ArrayList;
import java.util.List;

public class ReservationData {
    private String movieTitle;
    private String movieTime;
    private int peopleCount;
    private List<String> selectedSeats;
    private int totalPrice;

    public ReservationData() {
        this.selectedSeats = new ArrayList<>();
        this.peopleCount = 0;
        this.totalPrice = 0;
    }

    // Getters and Setters
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
        calculateTotalPrice();
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

    public int getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotalPrice() {
        // 1인당 12,000원으로 계산
        this.totalPrice = peopleCount * 12000;
    }

    public void reset() {
        this.movieTitle = null;
        this.movieTime = null;
        this.peopleCount = 0;
        this.selectedSeats.clear();
        this.totalPrice = 0;
    }
}