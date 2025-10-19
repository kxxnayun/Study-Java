package ch06;

public class TimeTest {
    static void main() {
        Time time1 = new Time();
        System.out.println(time1);

        Time time2 = new Time(13, 27, 9);
        System.out.println(time2);

        Time time3 = new Time(99, 99, 99);
        System.out.println(time3);
    }
}
