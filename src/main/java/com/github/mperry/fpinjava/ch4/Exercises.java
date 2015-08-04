package com.github.mperry.fpinjava.ch4;

import fj.F;
import fj.F2;
import fj.data.List;
import fj.data.Option;

/**
 * Created by MarkPerry on 4/08/2015.
 */
public class Exercises {


    static <A, B, C> Option<C> liftM2(Option<A> oa, Option<B> ob, F2<A, B, C> f) {
        // TODO: implement
        return null;
    }

    static <A> Option<List<A>> sequence(List<Option<A>> list) {
        // TODO: implement
        return null;
    }

    static <A, B> Option<List<B>> traverse(List<A> list, F<A, Option<B>> f) {
        // TODO: implement
        return null;
    }

}
