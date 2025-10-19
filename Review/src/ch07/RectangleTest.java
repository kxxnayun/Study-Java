package ch07;

public class RectangleTest {
    static void main() {
        Rectangle r = new Rectangle();

        r.setX(3);
        r.setY(5);
        r.setWidth(10);
        r.setHeight(30);

        r.print();
        r.draw();

    }
}
