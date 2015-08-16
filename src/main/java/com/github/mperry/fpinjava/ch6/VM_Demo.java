package com.github.mperry.fpinjava.ch6;

import fj.Unit;
import fj.data.List;
import fj.data.State;
import org.junit.Assert;
import org.junit.Test;

import static com.github.mperry.fpinjava.ch6.VM_Demo.Input.COIN;
import static com.github.mperry.fpinjava.ch6.VM_Demo.Input.TURN;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by MarkPerry on 17/08/2015.
 */
public class VM_Demo {

	static enum Input { COIN, TURN };

	public static void sim() {
//		VendingMachine vm = ImmutableVendingMachine.builder().coins(1).items(1).locked(true).build();
	}

	static VendingMachine vm(boolean locked, int items, int coins) {
		VendingMachine vm = ImmutableVendingMachine.builder().coins(coins).items(items).locked(locked).build();
		return vm;
	}

	static VendingMachine next(VendingMachine vm, Input i) {
		if (vm.items() == 0) {
			return vm;
		} else if (!vm.locked() && i == COIN) {
			return vm;
		} else if (vm.locked() && i == TURN) {
			return vm;
		} else if (vm.locked() && i == COIN) {
			return vm(false, vm.items(), vm.coins() + 1);
		} else if (!vm.locked() && i == TURN) {
			return vm(true, vm.items() - 1, vm.coins());
		} else {
			return vm;
		}
	}

	static State<VendingMachine, VendingMachine> simulate(List<Input> list) {
		return list.foldLeft((st, i) -> st.map(vm -> next(vm, i)), State.init());
	}



	public static void main(String [] args) {

	}

	@Test
	public void test() {
		State<VendingMachine, VendingMachine> st = simulate(List.list(COIN, TURN, TURN, COIN, COIN, TURN));
		VendingMachine vm1 = st.eval(vm(true, 5, 0));
		VendingMachine oracle = st.eval(vm(true, 3, 2));
		assertThat(vm1, equalTo(oracle));

	}


}
