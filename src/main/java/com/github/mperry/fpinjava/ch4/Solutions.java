package com.github.mperry.fpinjava.ch4;

import fj.F;
import fj.F2;
import fj.data.List;
import fj.data.Option;

/**
 * Created by MarkPerry on 4/08/2015.
 */
public class Solutions {


    static <A, B, C> Option<C> liftM2(Option<A> oa, Option<B> ob, F2<A, B, C> f) {
        return oa.bind(a -> ob.map(b -> f.f(a, b)));
    }

    static <A> Option<List<A>> sequence(List<Option<A>> list) {
        return list.foldRight((oa, acc) -> acc.bind(la -> oa.map(a -> la.cons(a))),
                Option.some(List.<A>nil())
        );
    }

    static <A, B> Option<List<B>> traverse(List<A> list, F<A, Option<B>> f) {
        return sequence(list.map(f));
    }

}
