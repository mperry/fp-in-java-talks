package com.github.mperry.fpinjava.ch7;

import fj.P2;
import fj.data.Seq;

/**
 * Created by MarkPerry on 10/10/2015.
 */
public class DemoTest {

    static int sum(Seq<Integer> ints) {
        return ints.foldLeft((a, b) -> a + b, 0);
    }

    static int sum2(Seq<Integer> ints) {
        int n = ints.length();
        if (n <= 1) {
            return n == 0 ? 0 : ints.head();
        } else {
            P2<Seq<Integer>, Seq<Integer>> p = ints.split(n / 2);
            return sum2(p._1()) + sum2(p._2());
        }
    }

    static int sum3(Seq<Integer> ints) {
        int n = ints.length();
        if (n <= 1) {
            return n == 0 ? 0 : ints.head();
        } else {
            P2<Seq<Integer>, Seq<Integer>> p = ints.split(n / 2);
            Par<Integer> l = Par.unit(() -> sum3(p._1()));
            Par<Integer> r = Par.unit(() -> sum3(p._2()));
            return l.get() + r.get();
        }
    }

}
