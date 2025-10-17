package ch05;

import java.util.Scanner;

public class StringTest {
    static void main() {
        String str;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("문자열을 입력하세요: ");
            str = scan.next();

            if(str.equals("quit") == true) {
                break;
            }
            if (str.matches("^www\\.(.+)")) {
                System.out.println("www로 시작합니다.");
            } else {
                System.out.println("www로 시작하지 않습니다.");
            }
        }
    }
}
