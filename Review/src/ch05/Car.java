package ch05;

public class Car {
    String color;
    int speed;
    int gear;

    public String toString() {
        return "Car color: " + color + ", speed: " + speed + ", gear: " + gear;
    }

    void changeGear (int g) {
        gear = g;
    }

    void changeSpeed (int s) {
        speed = s;
    }

    void changeColor (String c) {
        color = c;
    }

    void speedUp() {
        speed += 10;
    }

    void speedDown() {
        speed-= 10;
    }
}
