package ch06;

public class DateTest {
    static void main() {
        Date date1 = new Date(2025, "10월", 19);
        Date date2 = new Date(2024);
        Date date3 = new Date();

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }
}
