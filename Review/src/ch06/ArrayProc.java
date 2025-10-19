package ch06;

import java.util.Scanner;

public class ArrayProc {
    public void getValues(int[] array) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < array.length; i++) {
            System.out.print("성적을 입력하세요: ");
            array[i] = scanner.nextInt();
        }
    }

    public double getAverage(int[] array) {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total / array.length;
    }
}
