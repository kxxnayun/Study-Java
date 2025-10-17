package ch05;

public class Television {
    int channel;
    int volume;
    boolean onOff;

    void print() {
        System.out.println("채널: " + channel + " 볼륨: " + volume);
    }

    int getChannel() {
        return channel;
    }

    void setChannel(int ch) {
        channel = ch;
    }
}
