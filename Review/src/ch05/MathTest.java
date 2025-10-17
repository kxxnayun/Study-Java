package ch05;

public class MathTest {
    static void main() {
        int sum;
        Math obj = new Math();
        sum = obj.add(2, 3);
        System.out.println("sum = " + sum);
        sum = obj.add(7, 8);
        System.out.println("sum = " + sum);
    }
}
