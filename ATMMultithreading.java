package com.demoprograms;

class ATM {
	synchronized void  checkBalance(String name ) {
		System.out.print(name+" Checking the ");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Balance");
		
	}

	synchronized void withdraw(String name,int amount) {
		System.out.print(name+" Withdrawn "+amount+" ");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( );
		System.out.println( name +" Completed the Transaction!! ");
		System.out.println("Please wait for few seconds");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Customer extends Thread {
	ATM atm;
	String name;
	int amount;

	Customer(ATM atm,String name,int amount) {
		this.atm = atm;
		this.name = name;
		this.amount=amount;

	}

	public void useATM() {
		atm.checkBalance(name);
		atm.withdraw(name,amount);
	}
	public void run() {
		useATM();
	}
}

public class ATMMultithreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM a = new ATM();
		Customer c = new Customer(a,"Abhilash",10000);
		Customer c1 = new Customer(a,"Kiran Gowda",200000);
		c.start();
		c1.start();
		
	}

}
