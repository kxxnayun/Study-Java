package ch04;

public class ArrayTest1 {
    static void main() {
        int[] s = new int[10];

        for (int i = 0; i < s.length; i++) {
            s[i] = i;
        }

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + " ");
        }
    }
}
