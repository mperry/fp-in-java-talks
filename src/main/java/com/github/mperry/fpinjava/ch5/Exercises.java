package com.github.mperry.fpinjava.ch5;

import fj.*;
import fj.data.List;
import fj.data.Option;
import fj.data.Stream;

/**
 * Created by MarkPerry on 6/08/2015.
 */
public class Exercises {

	static <A, B> B foldLeft(Stream<A> s, B b, F2<B, A, B> f) {
		B result = b;
		while (s.isNotEmpty()) {
			result = f.f(result, s.head());
		}
		return result;
	}

	static <A> List<A> toList(Stream<A> s) {
		// TODO: use foldLeft above
		return null;
	}

	static <A> Stream<A> take(Stream<A> s, int n) {
		// TODO: use foldLeft above
		return null;
	}

	static <A> Stream<A> takeWhile(Stream<A> s, F<A, Boolean> f) {
		// TODO: use foldLeft above
		return null;
	}

	static <A, B> B foldRight(Stream<A> s, F0<B> acc, F2<F0<B>, A, B> f) {
		// TODO
		return null;
	}

	static <A> boolean exists(Stream<A> s, F<A, Boolean> f) {
		// TODO: use foldRight
		return false;
	}

	static <A> boolean forAll(Stream<A> s, F<A, Boolean> f) {
		// TODO: use foldRight
		return false;
	}

	static <A> Stream<A> takeWhile2(Stream<A> s, F<A, Boolean> f) {
		// TODO: use foldRight
		return null;
	}

	static <A, B> Stream<B> map(Stream<A> s, F<A, B> f) {
		// TODO: use foldRight
		return null;
	}

	static <A> Stream<A> filter(Stream<A> s, F<A, Boolean> f) {
		// TODO: use foldRight
		return null;
	}

	static <A> Stream<A> append(Stream<A> s, Stream<A> s2) {
		// TODO: use foldRight
		return null;
	}

	static <A, B> Stream<B> bind(Stream<A> s, F<A, Stream<B>> f) {
		// TODO: use foldRight
		return null;
	}

	// infinite streams: use cons below to implement each method

    static <A> Stream<A> cons(A a, F0<Stream<A>> f) {
        return Stream.cons(a, P.lazy(f));
    }

    static <A> Stream<A> repeat(A a) {
		// TODO
		return null;
	}

	static Stream<Integer> from(int i) {
		// TODO
		return null;
	}

	static Stream<Integer> range(int low, int high) {
		// TODO
		return null;
	}

	static Stream<Integer> fibonacci(int a, int b) {
		// TODO
		return null;
	}

	static <A, S> Stream<A> unfold(S s, F<S, Option<P2<A, S>>> f) {
		// TODO
		return null;
	}

}
