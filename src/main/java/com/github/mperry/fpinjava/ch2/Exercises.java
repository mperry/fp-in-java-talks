package com.github.mperry.fpinjava.ch2;

import fj.F;
import fj.F2;

import java.util.List;

/**
 * Created by MarkPerry on 13/07/2015.
 */
public class Exercises {

    static <A, B, C> F<A, C> andThen(F<A, B> f, F<B, C> g) {
        return null;
    }

    static <A, B> B fold(List<A> list, B b, F2<A, B, B> f) {
        return null;
    }

    static <A, B, C> F<B, C> partial(A a, F2<A, B, C> f) {
        return null;
    }

}
