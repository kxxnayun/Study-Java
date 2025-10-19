package ch06;

public class Student {
    private int number;
    private String name;
    private int age;

    Student() {
        number = 100;
        name = "나윤";
        age = 22;
    }

    Student (int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student number: "  + number + ", name: " + name + ", age: " + age;
    }
}
