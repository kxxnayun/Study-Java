package ch06;

public class Date {
    private int year;
    private String month;
    private int day;

    public Date() {
        this(2004, "9월",9);
    }

    public Date(int year) {
        this(year, "1월", 1);
    }

    public Date(int year, String month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return "Date: " + year + " " + month + " " + day;
    }
}
