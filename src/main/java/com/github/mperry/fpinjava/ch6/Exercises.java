package com.github.mperry.fpinjava.ch6;

import fj.F;
import fj.F2;
import fj.P;
import fj.P2;
import fj.Unit;
import fj.data.List;
import fj.data.State;

/**
 * Created by MarkPerry on 16/08/2015.
 */
public class Exercises {


	static <S, A> State<S, A> constant(A a) {
		return null;
	}

	static <S, A, B> State<S, B> map(State<S, A> st, F<A, B> f){
		return null;
	}

	static <S, A, B, C> State<S, C> map2(State<S, A> st1, State<S, B> st2, F2<A, B, C> f) {
		return null;
	}

	static <S, A, B> State<S, B> flatMap(State<S, A> st1, F<A, State<S, B>> f) {
		return null;
	}

	static <S, A> State<S, List<A>> sequence(List<State<S, A>> list) {
		return null;
	}

	static <S, A, B> State<S, List<B>> traverse(List<A> list, F<A, State<S, B>> f) {
		return null;
	}

	// imperative exercises


	static <S> State<S, Unit> set(S s) {
		return null;
	}

	static <S> State<S, S> get() {
		return null;
	}

	static <S, A> State<S, Unit> modify(State<S, A> st, F<S, S> f) {
		return null;
	}

}
