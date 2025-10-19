package ch06;

public class AccountTest {
    static void main() {
        Account obj = new Account();
        obj.setName("Tom");
        obj.setBalance(1000000);
        System.out.println("이름: " + obj.getName() + ", 잔액: " + obj.getBalance());
    }
}
