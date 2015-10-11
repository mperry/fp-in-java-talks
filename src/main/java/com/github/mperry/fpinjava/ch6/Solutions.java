package com.github.mperry.fpinjava.ch6;

import fj.F;
import fj.F2;
import fj.P;
import fj.P2;
import fj.Unit;
import fj.data.List;
import fj.data.State;

import static fj.P.p;

/**
 * Created by MarkPerry on 16/08/2015.
 */
public class Solutions {

	static <S, A> State<S, A> constant(A a) {
		return State.unit(s -> P.p(s, a));
	}
	
	static <S, A, B> State<S, B> map(State<S, A> st, F<A, B> f){
		return State.unit(s -> {
			P2<S, A> p = st.run(s);
			B b = f.f(p._2());
			return P.p(p._1(), b);
		});
	}

	static <S, A, B, C> State<S, C> map2(State<S, A> st1, State<S, B> st2, F2<A, B, C> f) {
		return State.unit(s -> {
			P2<S, A> p1 = st1.run(s);
			P2<S, B> p2 = st2.run(p1._1());
			C c = f.f(p1._2(), p2._2());
			return P.p(p2._1(), c);
		});
	}

	static <S, A, B> State<S, B> flatMap(State<S, A> st1, F<A, State<S, B>> f) {
		return State.unit(s -> {
			P2<S, A> p = st1.run(s);
			State<S, B> st2 = f.f(p._2());
			return st2.run(p._1());
		});
	}

	static <S, A> State<S, List<A>> sequence(List<State<S, A>> list) {
		return list.foldLeft((State<S, List<A>> acc, State<S, A> st) ->
			acc.flatMap((List<A> as) -> st.map((A a) -> as.snoc(a))),
			constant(List.<A>nil())
		);
	}

	static <S, A, B> State<S, List<B>> traverse(List<A> list, F<A, State<S, B>> f) {
		return sequence(list.map(f));
	}

	// imperative exercises


	static <S> State<S, Unit> set(S s) {
		return State.unit(st -> P.p(s, Unit.unit()));
	}

	static <S> State<S, S> get() {
		return State.unit(s -> P.p(s, s));
	}

	static <S, A> State<S, Unit> modify(State<S, A> st, F<S, S> f) {
		return State.unit(s -> {
			P2<S, A> p = st.run(s);
			S s2 = f.f(p._1());
			return P.p(s2, Unit.unit());
		});
	}

	public static <S> State<S, S> init() {
		return State.unit(s -> p(s, s));
	}

}
