package com.github.mperry.fpinjava.ch4;

import fj.F;
import fj.F2;
import fj.data.List;
import fj.data.Option;
import fj.data.Validation;

/**
 * Created by MarkPerry on 4/08/2015.
 */
public class Exercises {

    // Option methods

    static <A, B> Option<B> map(Option<A> oa, F<A, B> f) {
        // TODO: implement
        return null;
    }

    static <A> Option<A> filter(Option<A> oa, F<A, Boolean> f) {
        // TODO: implement
        return null;
    }

    static <A, B> Option<B> bind(Option<A> oa, F<A, Option<B>> f) {
        // TODO: implement
        return null;
    }

    static <A, B, C> Option<C> liftM2(Option<A> oa, Option<B> ob, F2<A, B, C> f) {
        // TODO: implement
        return null;
    }

    static <A> Option<List<A>> sequenceOption(List<Option<A>> list) {
        // TODO: implement
        return null;
    }

    static <A, B> Option<List<B>> traverseOption(List<A> list, F<A, Option<B>> f) {
        // TODO: implement
        return null;
    }

    // Validation methods

    static <E, A, B> Validation<E, B> map(Validation<E, A> v, F<A, B> f) {
        // TODO: implement
        return null;
    }

    static <E, A, B> Validation<E, B> bind(Validation<E, A> v, F<A, Validation<E, B>> f) {
        // TODO: implement
        return null;
    }

    static <E, A> Validation<E, A> orElse(Validation<E, A> v1, Validation<E, A> v2) {
        // TODO: implement
        return null;
    }

    static <E, A, B, C> Validation<E, C> liftM2(Validation<E, A> v1, Validation<E, B> v2, F2<A, B, C> f) {
        // TODO: implement
        return null;
    }

    static <E, A> Validation<E, List<A>> sequenceValidation(List<Validation<E, A>> list) {
        // TODO: implement
        return null;
    }

    static <E, A, B> Validation<E, List<B>> traverseValidation(List<A> list, F<A, Validation<E, B>> f) {
        // TODO: implement
        return null;
    }

}
