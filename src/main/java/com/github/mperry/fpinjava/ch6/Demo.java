package com.github.mperry.fpinjava.ch6;

import fj.LcgRng;
import fj.Rng;
import org.junit.Test;

/**
 * Created by MarkPerry on 16/08/2015.
 */
public class Demo {

	@Test
	public void test1() {
		Rng r = new LcgRng(10);
		long a = r.nextLong()._2(); // 3847489
		long b = r.nextLong()._2();

		Rng r2 = r.nextLong()._1();
		long c = r2.nextLong()._2();

		System.out.println("a : " + a + " b: " + b + " c: " + c);

	}


}
