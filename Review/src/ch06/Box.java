package ch06;

public class Box {
    private int width;
    private int length;
    private int height;
    private int volume;

    Box(int w, int l, int h) {
        width = w;
        length = l;
        height = h;
        volume = width * length * height;
    }

    public int getVolume() {
        return volume;
    }
}
