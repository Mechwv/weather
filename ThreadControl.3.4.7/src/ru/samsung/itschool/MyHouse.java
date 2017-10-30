package ru.samsung.itschool;

public class MyHouse {
	private boolean pizzaArrived = false;

	public void eatPizza() {
		synchronized (this) {
			while (!pizzaArrived) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
		}
		System.out.println("yumyum...");
	}

	public void pizzaGuy() {
		synchronized (this) {
			pizzaArrived = true;
			notifyAll();
		}
	}
}
