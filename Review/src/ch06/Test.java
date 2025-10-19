package ch06;

class A {
    private int a; // 전용
    int b; // 디폴트
    public int c; // 공용
}

public class Test {
    static void main() {
        A obj = new A(); // 객체 생성

        // obj.a =  10; // 전용 멤버는 다른 클래스에서 접근 불가
        obj.b =  20; // 디폴트 멤버 가능
        obj.c =  30; // 공용 멤버 가능
    }
}
