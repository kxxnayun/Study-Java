package ch06;

public class StudentTest {
    static void main() {
        Student s1 = new Student();
        System.out.println(s1);

        Student s2 = new Student(1, "kim", 21);
        System.out.println(s2);
    }
}
