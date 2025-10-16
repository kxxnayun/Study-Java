package ch04;

import java.util.Arrays;

public class SortExample {
    static void main() {
        int SIZE = 10;
        int[] numbers = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            int r = (int) (Math.random() * 100); // 형 변환
            numbers[i] = r;
        }

        System.out.print("최초의 리스트: ");
        for (int r: numbers)
            System.out.print(r + " ");
        Arrays.sort(numbers);

        System.out.print("\n정렬된 리스트: ");
        for (int r: numbers)
            System.out.print(r + " ");
    }
}
