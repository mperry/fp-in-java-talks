package com.github.mperry.fpinjava.ch6;

/**
 * Created by MarkPerry on 17/08/2015.
 */
public class VM_Demo {

	private boolean locked;
	private int items;
	private int coins;

	enum Input { COIN, TURN };

	public VM_Demo(boolean lock, int initalItems, int initialCoins) {
		locked = lock;
		items = initalItems;
		coins = initialCoins;
	}

	public static void sim() {
		VendingMachine vm = ImmutableVendingMachine.builder().coins(1).items(1).locked(true).build();
	}

	public static void main(String [] args) {

	}

}
