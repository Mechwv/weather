package ru.samsung.itschool;

class Work extends Thread {
	String threadName;

	public Work(String name) {
		threadName = name;
	}

	@Override
	public void run() {
		int max=(int) (20*Math.random());
		for (int i = 0; i < max; i++) {
			try {
				sleep(1000);
				System.out.print(threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}