package ch04;

import java.util.Scanner;

public class SeqSerach {
    static void main() {
        int s[] = { 1, 2, 3, 4, 5, 6 };
        int value, index = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("값을 입력하세요: ");
        value = scanner.nextInt();

        for (int i = 0; i < s.length; i++) {
            if (s[i] == value) {
                index = i;
            }
        }

        System.out.println(index);
    }
}
