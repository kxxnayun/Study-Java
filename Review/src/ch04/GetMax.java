package ch04;

public class GetMax {
    static void main() {
        int num[] = { 1, 2, 3, 4, 5, 6 };
        int maximum;

        maximum = num[0];

        for(int i = 1; i < num.length; i++) {
            if (num[i] > maximum) {
                maximum = num[i];
            }
        }

        System.out.println("최대값: " + maximum);
    }
}
