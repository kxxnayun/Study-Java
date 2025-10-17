package ch05;

public class TelevisionTest {
    static void main() {
//        Television tv1 = new Television();
//        tv1.channel = 7;
//        tv1.volume = 9;
//        tv1.onOff = true;
//        int ch = tv1.getChannel();
//        System.out.println("현재 채널: " + ch);
//        tv1.print();

        Television tv1 = new Television();
        tv1.setChannel(11);
        int ch1 = tv1.getChannel();
        System.out.println(ch1);

//        Television tv2 = new Television();
//        tv2.channel = 10;
//        tv2.volume = 3;
//        tv2.onOff = false;
//        tv2.print();

        Television tv2 = new Television();
        tv2.setChannel(5);
        int ch2 = tv2.getChannel();
        System.out.println(ch2);
    }
}
