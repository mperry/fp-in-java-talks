package com.github.mperry.fpinjava.ch6;

import fj.P2;
import fj.data.List;
import fj.data.State;
import org.junit.Test;

import static com.github.mperry.fpinjava.ch6.Simulation.Input.COIN;
import static com.github.mperry.fpinjava.ch6.Simulation.Input.TURN;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by MarkPerry on 17/08/2015.
 */
public class Simulation {

	static enum Input { COIN, TURN };

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

	@Test
	public void test() {
		State<VendingMachine, VendingMachine> st = simulate(List.list(COIN, TURN, TURN, COIN, COIN, TURN));
		VendingMachine start = vm(true, 5, 0);

		P2<VendingMachine, VendingMachine> p = st.run(start);
		System.out.println(p);

		VendingMachine actual = st.eval(start);
		VendingMachine oracle = vm(true, 3, 2);
		assertThat(oracle, equalTo(actual));
	}


}
