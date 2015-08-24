package com.github.mperry.fpinjava.ch6;

import fj.P2;
import fj.data.List;
import fj.data.State;
import org.junit.Test;

import static com.github.mperry.fpinjava.ch6.SimulationExercise.Input.COIN;
import static com.github.mperry.fpinjava.ch6.SimulationExercise.Input.DOOR;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by maperry on 24/08/2015.
 */
public class SimulationExercise {

    static enum Input {COIN, DOOR};

    static VendingMachine vm(boolean locked, int items, int coins) {
        return ImmutableVendingMachine.builder().coins(coins).items(items).locked(locked).build();
    }

    static VendingMachine next(VendingMachine vm, Input i) {
        // TODO
        return null;
    }

    static State<VendingMachine, VendingMachine> createState(List<Input> list) {
        // TODO
        return null;
    }

    static VendingMachine simulate(VendingMachine start, List<Input> inputs) {
        // TODO
        return null;
    }

    static VendingMachine simulate() {
        /*
         * vm(true, 5, 0)
         * COIN -> vm(false, 5, 1)
         * DOOR -> vm(true, 4, 1)
         * DOOR -> vm(true, 4, 1)
         * COIN -> vm(false, 4, 2)
         * COIN -> vm(false, 4, 2)
         * DOOR -> vm(true, 3, 2)
         */
        return simulate(vm(true, 5, 0), List.list(COIN, DOOR, DOOR, COIN, COIN, DOOR));
    }

    @Test
    public void test() {
        assertThat(simulate(), equalTo(vm(true, 3, 2)));
    }

    public static void main(String args[]) {
        simulate();
    }

}
