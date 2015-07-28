package com.github.mperry.fpinjava.ch2;

import fj.F;
import fj.F2;

import java.util.List;

/**
 * Created by MarkPerry on 13/07/2015.
 */
public class Solution {

    static <A, B, C> F<A, C> andThen(F<A, B> f, F<B, C> g) {
        return a -> g.f(f.f(a));
    }

    static <A, B> B fold(List<A> list, B b, F2<A, B, B> f) {
        B result = b;
        for (A a: list) {
            result = f.f(a, result);
        }
        return result;
    }

    static <A, B, C> F<B, C> partial(A a, F2<A, B, C> f) {
        return b -> f.f(a, b);
    }

}
