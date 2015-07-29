package com.github.mperry.fpinjava.ch3;

import fj.F;
import fj.F2;

import fj.F3;
import fj.data.List;
import org.junit.Assert;
import org.junit.Test;

import static com.github.mperry.fpinjava.ch3.Tree.leaf;
import static com.github.mperry.fpinjava.ch3.Tree.tree;

/**
 * Created by MarkPerry on 13/07/2015.
 */
public class Exercises {

    static <A> List<A> drop(List<A> list, int n) {
        //  TODO: implement method using recursion
        return null;
    }

    static <A> List<A> dropWhile(List<A> list, F<A, Boolean> f) {
        //  TODO: implement method using recursion
        return null;
    }


    static <A> List<A> reverse(List<A> list) {
        //  TODO: implement method using fold
        return null;
    }

    static <A, B> List<B> map(List<A> list, F<A, B> f) {
        //  TODO: implement method using fold
        return null;
    }

    static <A> List<A> flatten(List<List<A>> list) {
        //  TODO: implement method
        return null;
    }

    static <A, B> List<B> flatMap(List<A> list, F<A, List<B>> f) {
        //  TODO: implement method
        return null;
    }

    ////////////////////////////
    // trees
    ////////////////////////////


    ////////////////////////////
    // trees
    ////////////////////////////


    static <A, B> B foldLeft(Tree<A> tree, B acc, F2<B, A, B> f) {
        // TODO: implement method
        return null;
    }

    static <A, B> B foldMap(Tree<A> tree, B empty, F3<B, A, B, B> join) {
        // TODO: implement method
        return null;
    }

    static <A, B> B foldMap2(Tree<A> tree, B empty, F<A, B> f, F2<B, B, B> join) {
        // TODO: implement method
        return null;
    }

    static <A> int size(Tree<A> tree) {
        // TODO: implement method
        return 0;
    }

    static <A> int depth(Tree<A> tree) {
        // TODO: implement method
        return 0;
    }

    static <A, B> Tree<B> map(Tree<A> t, F<A, B> f) {
        // TODO: implement method
        return null;
    }

    static <A> List<A> traverseLeft(Tree<A> t) {
        // TODO: implement method
        return null;
    }

}
