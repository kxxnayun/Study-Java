package day1209;

class MyTread extends Thread {
	public void run() {
		for (int i = 10; i >= 0; i--) {
			System.out.print(i + " ");
		}
	}
}

public class MyThreadTest {
	public static void main(String args[]) {
		Thread t = new MyTread();
		t.start();
	}
}
