package com.github.mperry.fpinjava.ch2;

import fj.F;

import static java.lang.System.out;

/**
 * Created by MarkPerry on 13/07/2015.
 */
public class Example {

    static <A, B, C> F<A, C> andThen(F<A, B> f, F<B, C> g) {
        return a -> g.f(f.f(a));
    }

}
