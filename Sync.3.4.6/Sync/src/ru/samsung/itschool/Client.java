package ru.samsung.itschool;

import ru.samsung.itschool.SynchronizedLogic.Account;

class Client extends Thread {
	Account account;

	public Client(Account acc) {
		account = acc;
	}

	@Override
	public void run() {
//		synchronized (account) {
			if (account.money - 70 > 0) { // достаточно ли средств ?
				try {
					sleep((long) (1000 * Math.random()));  // иммитируем задержку банкомата
				} catch (InterruptedException e) {}
				account.money -= 70;  // снимаем со счета нужную сумму
				System.out.println(account.money);
			}
			else System.out.println("there are not enough funds on your account");
//		}
	}
}
