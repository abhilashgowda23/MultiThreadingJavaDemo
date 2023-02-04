package com.demoprograms;

class MyData {
	int value ;
	boolean flag = true;

	synchronized public void setValue(int x) {
		while (flag != true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			value = x;
			flag = false;
			notify();
		}

	}

	synchronized public int getValue() {
		int x = 0;
		while (flag != false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x = value;
			flag = true;
			notify();
		}
		return x = value;
	}
}

class Producer extends Thread {
	MyData d;

	public Producer(MyData m) {

		d = m;
	}

	public void run() {
		int n = 0, count = 1;
		while (n <= 5)
			d.setValue(count);
		System.out.println("Prodecer" + count);
		count++;

	}

}

class Consumer extends Thread {
	MyData d;

	public Consumer(MyData m) {
		super();
		this.d = m;
	}

	public void run() {

		int n = 0, count = 1;
		while (n <= 5) {
			int ab = d.getValue();
			System.out.println("Consumer" + count);
		}

	}
}

public class InterThreadComExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyData m = new MyData();
		Producer p = new Producer(m);
		Consumer c = new Consumer(m);
		p.start();
		c.start();

	}

}
