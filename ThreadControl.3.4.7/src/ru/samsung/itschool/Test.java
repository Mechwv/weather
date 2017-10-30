package ru.samsung.itschool;

public class Test {

	MyHouse myHouse;

	class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			myHouse.eatPizza();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.myHouse = new MyHouse();
		MyThread thread = test.new MyThread();
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.myHouse.pizzaGuy();
	}
	
}
