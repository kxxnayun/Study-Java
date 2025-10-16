package ch04;

public class GetMin {
    static void main() {
        int s[] = { 1, 2, 3, 4, 5, 6 };
        int minimum;

        minimum = s[0];

        for (int i = 1; i < s.length; i++) {
            if (s[i] < minimum) {
                minimum = s[i];
            }
        }

        System.out.println("최소값: " + minimum);
    }
}
