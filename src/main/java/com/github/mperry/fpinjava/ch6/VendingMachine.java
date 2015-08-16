package com.github.mperry.fpinjava.ch6;

import org.immutables.value.Value;

/**
 * Created by MarkPerry on 17/08/2015.
 */

@Value.Immutable
public interface VendingMachine {

	int coins();
	int items();
	boolean locked();

}
