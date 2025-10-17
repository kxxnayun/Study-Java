package ch04;

import java.util.Scanner;

public class Tic_Tac_Toe {
    static void main() {
        char[][] board = new char[3][3];
        int x, y;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        do {
            for (int i = 0; i < 3; i++) {
                System.out.println(" " + board[i][0] + " | " + " " + board[i][1] + "| " + board[i][1] + " | ");

                if (i != 2) {
                    System.out.println("---|---|---");
                }
            }

            System.out.println("다음 수의 좌표를 입력하시오: ");
            x = scanner.nextInt();
            y = scanner.nextInt();

            if (board[x][y] != ' ') {
                System.out.println("잘못된 위치입니다. ");
                continue;
            } else {
                board[x][y] = 'x';
            }

            int i = 0, j = 0;
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (board[i][j] == ' '){
                        break;
                    }
                }
                if (board[i][j] == ' '){
                    break;
                }
            }
            if (i < 3 && j < 3)
                board[i][j] = '0';
        } while (true);
    }
}
