package com.github.mperry.fpinjava.ch5;

import fj.*;
import fj.data.List;
import fj.data.Option;
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

	static <A> Stream<A> takeWhile(Stream<A> s, F<A, Boolean> f) {
		if (s.isEmpty()) {
			return s;
		} else {
			if (f.f(s.head())) {
				return Stream.cons(s.head(), P.lazy(() -> takeWhile(s.tail()._1(), f)));
			} else {
				return s;
			}
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

	static <A> Stream<A> takeWhile2(Stream<A> s, F<A, Boolean> f) {
		return foldRight(s, () -> Stream.<A>nil(), (ls, a) -> f.f(a) ? ls.f().cons(a) : Stream.nil());
	}

	static <A, B> Stream<B> map(Stream<A> s, F<A, B> f) {
		return foldRight(s, () -> Stream.nil(), (ls, a) -> ls.f().cons(f.f(a)));
	}

	static <A> Stream<A> filter(Stream<A> s, F<A, Boolean> f) {
		return foldRight(s, () -> Stream.<A>nil(), (ls, a) ->
			f.f(a) ? Stream.cons(a, P.lazy(ls)) : ls.f()
		);
	}

	static <A> Stream<A> append(Stream<A> s, Stream<A> s2) {
		return s.isEmpty() ? s2 :
				Stream.cons(
					s.head(),
					P.lazy(() -> foldRight(s.tail()._1(), () -> Stream.<A>nil(), (ls, a) -> Stream.cons(a, P.lazy(() -> ls.f()))))
				);
	}

	static <A, B> Stream<B> bind(Stream<A> s, F<A, Stream<B>> f) {
		if (s.isEmpty()) {
			return Stream.<B>nil();
		} else {
			return foldRight(s, () -> Stream.<B>nil(), (ls, a) -> f.f(a).append(ls));
		}
	}

	// infinite streams

	static <A> Stream<A> cons(A a, F0<Stream<A>> f) {
		return Stream.cons(a, P.lazy(f));
	}

	static <A> Stream<A> repeat(A a) {
		return cons(a, () -> repeat(a));
	}

	static Stream<Integer> from(int i) {
		return cons(i, () -> from(i + 1));
	}

	static Stream<Integer> range(int low, int high) {
		return low >= high ? Stream.nil() : cons(low, () -> range(low + 1, high));
	}

	static Stream<Integer> fibonacci(int a, int b) {
		return cons(a + b, () -> fibonacci(b, a + b));
	}

	static <A, S> Stream<A> unfold(S s, F<S, Option<P2<A, S>>> f) {
		Option<Stream<A>> os  = f.f(s).map(p2 -> cons(p2._1(), () -> unfold(p2._2(), f)));
		return os.orSome(Stream.nil());
	}

}
