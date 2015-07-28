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
 * Created by MarkPerry on 29/07/2015.
 */
public class Solutions {

    static <A, B> B foldLeft(List<A> list, B acc, F2<B, A, B> f) {
        if (list.isEmpty()) {
            return acc;
        } else {
            return foldLeft(list.tail(), f.f(acc, list.head()), f);
        }
    }

    static <A> List<A> drop(List<A> list, int n) {
        if (n <= 0 || list.isEmpty()) {
            return list;
        } else if (n == 1) {
            return list.tail();
        } else {
            return drop(list.tail(), n - 1);
        }
    }

    static <A> List<A> dropWhile(List<A> list, F<A, Boolean> f) {
        if (list.isEmpty()) {
            return list;
        } else if (f.f(list.head())) {
            return dropWhile(list.tail(), f);
        } else {
            return list;
        }
    }


    static <A> List<A> reverse(List<A> list) {
        return list.foldLeft((acc, a) -> List.cons(a, acc), List.nil());
    }

    static <A, B> List<B> map(List<A> list, F<A, B> f) {
        return foldLeft(list, List.<B>nil(), (acc, a) -> acc.cons(f.f(a))).reverse();
    }

    static <A, B> List<B> flatMap(List<A> list, F<A, List<B>> f) {
        return foldLeft(list, List.nil(), (acc, a) -> acc.append(f.f(a)));
    }

    static <A> List<A> flatten(List<List<A>> list) {
        return foldLeft(list, List.<A>nil(), (List<A> acc, List<A> l) -> acc.append(l));
    }

    // trees


    static <A, B> B foldLeft(Tree<A> tree, B acc, F3<B, A, B, B> f) {
        if (tree.isEmpty()) {
            return acc;
        } else {
            B l = foldLeft(tree.left(), acc, f);
            B r = foldLeft(tree.right(), acc, f);
            B b = f.f(l, tree.node(), r);
            return b;
        }
    }

    static <A> int size(Tree<A> tree) {
        return foldLeft(tree, 0, (l, a, r) -> l + 1 + r);
    }

    static <A> int depth(Tree<A> tree) {
        // (current, old max)
        return foldLeft(tree, 0, (l, a, r) -> 1 + Math.max(l, r));
    }


    static <A, B> Tree<B> map(Tree<A> t, F<A, B> f) {
        return foldLeft(t, Tree.<B>empty(), (l, a, r) -> tree(l, f.f(a), r));
    }

    static <A> boolean eq(Tree<A> t1, Tree<A> t2) {
        if (t1.isEmpty() && t2.isEmpty()) {
            return true;
        } else if (t1.isEmpty() || t2.isEmpty()) {
            return false;
        } else {
            return eq(t1.left(), t2.left()) && t1.node().equals(t2.node()) && eq(t1.right(), t2.right());
        }
    }

    @Test
    public void testMap() {
        Tree<Integer> t = map(tree(leaf(1), 2, tree(leaf(3), 4, leaf(5))), a -> a + 1);
        Tree<Integer> t2 = tree(leaf(2), 3, tree(leaf(4), 5, leaf(6)));
        System.out.println(t);
        Assert.assertTrue(eq(t, t2));
    }

    static <A> List<A> traverseLeft(Tree<A> t) {
        return foldLeft(t, List.<A>nil(), (l, a, r) -> l.cons(a).reverse().append(r));
    }


}
