package ch04;

import java.util.Scanner;

public class TheaterReserve {
    static void main() {
        int size = 10;
        int[] seats = new int[size];

        while(true) {
            System.out.println("------------------------");
            for (int i = 0; i < size; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println("\n------------------------");
            for (int i = 0; i < size; i++) {
                System.out.print(seats[i] + " ");
            }
            System.out.println("\n------------------------");

            System.out.print("좌석 번호 입력 (종료는 -1): ");
            Scanner scanner = new Scanner(System.in);
            int s = scanner.nextInt();

            if (s == -1) {
                break;
            }
            else if (seats[s-1] == 0) {
                seats[s-1] = 1;
                System.out.println("예약 완료");
            }
            else {
                System.out.println("예약 불가");
            }
        }
    }
}
