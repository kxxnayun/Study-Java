package ch05;

public class BoxTest {
    static void main() {
        Box box = new Box();

        box.width = 20;
        box.height = 20;
        box.length = 30;

        System.out.println(box.height + " " + box.length + " " + box.length);
    }
}
