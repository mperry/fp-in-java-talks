package com.github.mperry.fpinjava.ch4;

import fj.F;
import fj.F2;
import fj.data.List;
import fj.data.Option;
import fj.data.Validation;

/**
 * Created by MarkPerry on 4/08/2015.
 */
public class Solutions {


    // Option methods

    static <A, B> Option<B> map(Option<A> oa, F<A, B> f) {
        return oa.isNone() ? Option.<B>none() : Option.some(f.f(oa.some()));
    }

    static <A> Option<A> filter(Option<A> oa, F<A, Boolean> f) {
        return oa.isSome() && f.f(oa.some()) ? oa : Option.<A>none();
    }

    static <A, B> Option<B> bind(Option<A> oa, F<A, Option<B>> f) {
        return oa.isNone() ? Option.<B>none() : f.f(oa.some());
    }

    static <A, B, C> Option<C> liftM2(Option<A> oa, Option<B> ob, F2<A, B, C> f) {
        return oa.bind(a -> ob.map(b -> f.f(a, b)));
    }

    static <A> Option<List<A>> sequenceOption(List<Option<A>> list) {
        return list.foldRight((oa, acc) -> acc.bind(la -> oa.map(a -> la.cons(a))),
                Option.some(List.<A>nil())
        );
    }

    static <A, B> Option<List<B>> traverseOption(List<A> list, F<A, Option<B>> f) {
        return sequenceOption(list.map(f));
    }

    // Validation methods

    static <E, A, B> Validation<E, B> map(Validation<E, A> v, F<A, B> f) {
        return v.isFail() ?
                Validation.fail(v.fail()) :
                Validation.success(f.f(v.success()));
    }

    static <E, A, B> Validation<E, B> bind(Validation<E, A> v, F<A, Validation<E, B>> f) {
        return v.isFail() ? Validation.fail(v.fail()) : f.f(v.success());
    }

    static <E, A> Validation<E, A> orElse(Validation<E, A> v1, Validation<E, A> v2) {
        return v1.isFail() ? v1 : v2;
    }

    static <E, A, B, C> Validation<E, C> liftM2(Validation<E, A> v1, Validation<E, B> v2, F2<A, B, C> f) {
        return bind(v1, a -> v2.map(b -> f.f(a, b)));
    }

    static <E, A> Validation<E, List<A>> sequenceValidation(List<Validation<E, A>> list) {
        return list.foldLeft((Validation<E, List<A>> acc, Validation<E, A> v) ->
                        acc.bind(la -> v.map(a -> la.cons(a))), Validation.success(List.nil())
        );
    }

    static <E, A, B> Validation<E, List<B>> traverseValidation(List<A> list, F<A, Validation<E, B>> f) {
        return sequenceValidation(list.map(f));
    }

}
