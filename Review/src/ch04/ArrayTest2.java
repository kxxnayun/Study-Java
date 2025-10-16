package ch04;

import java.util.Scanner;

public class ArrayTest2 {
    static void main() {
        int student = 5;
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        int scores[] = new int[student];

        for (int i = 0; i < scores.length; i++) {
            System.out.println("성적을 입력하시오:" );
            scores[i] = scanner.nextInt();
        }

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        System.out.println("평균 성적: " + total / student);
    }
}
