package ch06;

public class ArrayProcTest {
    final static int STUDENTS = 5;

    static void main() {
        int[] scores = new int[STUDENTS];
        ArrayProc obj = new ArrayProc();
        obj.getValues(scores);
        System.out.println(obj.getAverage(scores));
    }
}
