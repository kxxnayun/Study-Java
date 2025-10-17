package ch05;

public class CarTest {
    static void main() {
        Car car = new Car();

        car.changeGear(1);
        car.changeColor("빨강");
        car.changeSpeed(100);

        car.speedDown();

        System.out.println(car);
    }
}
