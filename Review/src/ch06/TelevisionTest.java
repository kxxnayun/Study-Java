package ch06;

public class TelevisionTest {
    static void main() {
        Television tv1 = new Television(7, 10, true);
        tv1.print();
        Television tv2 = new Television(10, 2, false);
        tv2.print();
    }
}
