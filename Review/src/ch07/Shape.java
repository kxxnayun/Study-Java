package ch07;

public class Shape {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) { // 반환값 없으니까 void 사용
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    void print() {
        System.out.println("x: " + x + ", y: " + y);
    }
}
