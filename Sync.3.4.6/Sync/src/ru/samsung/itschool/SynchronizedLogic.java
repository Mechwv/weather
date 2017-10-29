package ru.samsung.itschool;

public class SynchronizedLogic {
	public static Account account;
	
	class Account{
		public double money;
	}

	public static void main(String[] args) {
		account=new SynchronizedLogic().new Account();
		account.money=100.;
		Client client1=new Client(account);
		Client client2=new Client(account);
		client1.start();
		client2.start();
	}

}
