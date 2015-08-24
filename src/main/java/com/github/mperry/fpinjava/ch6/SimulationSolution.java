package com.github.mperry.fpinjava.ch6;

import fj.P2;
import fj.data.List;
import fj.data.State;
import org.junit.Test;

import static com.github.mperry.fpinjava.ch6.SimulationSolution.Input.COIN;
import static com.github.mperry.fpinjava.ch6.SimulationSolution.Input.DOOR;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by MarkPerry on 17/08/2015.
 */
public class SimulationSolution {

	static enum Input {COIN, DOOR};

	static VendingMachine vm(boolean locked, int items, int coins) {
		return ImmutableVendingMachine.builder().coins(coins).items(items).locked(locked).build();
	}

	static VendingMachine next(VendingMachine vm, Input i) {
		if (vm.items() == 0) {
			return vm;
		} else if (!vm.locked() && i == COIN) {
			return vm;
		} else if (vm.locked() && i == DOOR) {
			return vm;
		} else if (vm.locked() && i == COIN) {
			return vm(false, vm.items(), vm.coins() + 1);
		} else if (!vm.locked() && i == DOOR) {
			return vm(true, vm.items() - 1, vm.coins());
		} else {
			return vm;
		}
	}

	static State<VendingMachine, VendingMachine> createState(List<Input> list) {
		return list.foldLeft((st, i) ->
            st.map(vm -> next(vm, i)), State.init()
        );
	}

	static VendingMachine simulate() {
        return simulate(vm(true, 5, 0), List.list(COIN, DOOR, DOOR, COIN, COIN, DOOR));
	}

    static VendingMachine simulate(VendingMachine start, List<Input> list) {
        State<VendingMachine, VendingMachine> st = createState(list);
        P2<VendingMachine, VendingMachine> p = st.run(start);
        System.out.println(p);
        return p._2();
    }

    @Test
	public void test() {
		assertThat(simulate(), equalTo(vm(true, 3, 2)));
	}

	public static void main(String args[]) {
		simulate();
	}


}
