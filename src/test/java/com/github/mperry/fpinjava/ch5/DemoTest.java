package com.github.mperry.fpinjava.ch5;

import fj.Bottom;
import fj.P;
import fj.P1;
import fj.data.Stream;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MarkPerry on 7/08/2015.
 */
public class DemoTest {


	@Test
	public void laziness() {
		System.out.println("hi world");
		P1<Integer> p1 = P.p(1);
		P1<Integer> p2 = P.lazy(() -> {
			System.out.println("abc");
			return 1;
		});
		P1<Integer> p3 = P.<Integer>lazy(() -> {
			throw new Error();
		});
		P1<Integer> p4 = Bottom.error_("abc");

	}

	@Test
	public void lazyFold() {
		boolean b = Solutions.exists(Stream.range(1, 10), i -> i == 3);
		Assert.assertTrue(b);
	}

}
