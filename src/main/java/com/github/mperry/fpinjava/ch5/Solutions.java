package com.github.mperry.fpinjava.ch5;

import fj.F;
import fj.F0;
import fj.F2;
import fj.P;
import fj.data.List;
import fj.data.Stream;

/**
 * Created by MarkPerry on 6/08/2015.
 */
public class Solutions {

	static <A, B> B foldLeft(Stream<A> s, B b, F2<B, A, B> f) {
		B result = b;
		while (s.isNotEmpty()) {
			result = f.f(result, s.head());
		}
		return result;
	}

	static <A> List<A> toList(Stream<A> s) {
		return foldLeft(s, List.<A>nil(), (acc, a) -> acc.cons(a)).reverse();
	}

	static <A> Stream<A> take(Stream<A> s, int n) {
		if (n <= 0 || s.isEmpty()) {
			return s;
		} else {
			return Stream.cons(s.head(), P.lazy(() -> n == 1 ? Stream.<A>nil() : s.tail()._1().take(n - 1)));
		}
	}

	static <A, B> B foldRight(Stream<A> s, F0<B> acc, F2<F0<B>, A, B> f) {
		if (s.isEmpty()) {
			return acc.f();
		} else {
			return f.f(() -> foldRight(s.tail()._1(), acc, f), s.head());
		}
	}

	static <A> boolean exists(Stream<A> s, F<A, Boolean> f) {
		return foldRight(s, () -> false, (lb, a) -> f.f(a) || lb.f());
	}

	static <A> boolean forAll(Stream<A> s, F<A, Boolean> f) {
		return foldRight(s, () -> true, (lb, a) -> f.f(a) && lb.f());
	}

	static <A> Stream<A> takeWhile(Stream<A> s, F<A, Boolean> f) {
		return foldRight(s, () -> Stream.<A>nil(), (ls, a) -> f.f(a) ? ls.f().cons(a) : Stream.nil());
	}

	static <A, B> Stream<B> map(Stream<A> s, F<A, B> f) {
		return foldRight(s, () -> Stream.nil(), (ls, a) -> ls.f().cons(f.f(a)));
	}

	static <A> Stream<A> filter(Stream<A> s, F<A, Boolean> f) {
		// TODO
		return null;
	}

	static <A> Stream<A> append(Stream<A> s, Stream<A> s2) {
		// TODO
		return null;
	}

	static <A, B> Stream<B> bind(Stream<A> s, F<A, Stream<B>> f) {
		// TODO
		return null;
	}

	// infinite streams



}
