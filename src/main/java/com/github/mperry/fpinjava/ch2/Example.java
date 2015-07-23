package com.github.mperry.fpinjava.ch2;

import fj.F2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MarkPerry on 13/07/2015.
 */
public class Example {

    static void examples() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int sum = fold(list, 0, (a, acc) -> a + acc);
        int product = fold(list, 1, (a, acc) -> a * acc);
        String s = fold(list, "", (a, acc) -> acc + a);
    }

    static <A, B> B fold(List<A> list, B b, F2<A, B, B> f) {
        // TODO: implementation
        return null;
    }

}
