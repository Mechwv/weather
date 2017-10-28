package ru.samsung.itschool;

public class ParalleLogic {

	public static void main(String[] args) {
		Work work1 = new Work("A");
		Work work2 = new Work("B");
		Work work3 = new Work("C");
		work1.start();
		work2.start();
		work3.start();
	}

}
