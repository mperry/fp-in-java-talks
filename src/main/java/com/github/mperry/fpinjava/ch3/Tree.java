package com.github.mperry.fpinjava.ch3;

/**
 * Created by MarkPerry on 29/07/2015.
 */
public abstract class Tree<A> {

    public abstract boolean isEmpty();
    public abstract Tree<A> left();
    public abstract Tree<A> right();
    public abstract A node();

    public static class Empty<A> extends Tree<A> {
        private Empty() {
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Tree<A> left() {
            throw new Error("Left on tree leaf");
        }

        @Override
        public Tree<A> right() {
            throw new Error("Right on tree leaf");
        }

        @Override
        public A node() {
            throw new Error("Node on tree leaf");
        }
    }

    public static class Node<A> extends Tree<A> {
        Tree<A> left;
        A node;
        Tree<A> right;

        private Node(Tree<A> left, A node, Tree<A> right) {
            this.left = left;
            this.node = node;
            this.right = right;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Tree<A> left() {
            return left;
        }

        @Override
        public Tree<A> right() {
            return right;
        }

        @Override
        public A node() {
            return node;
        }
    }

    public static <A> Tree<A> tree(Tree<A> left, A a, Tree<A> right) {
        return new Node<>(left, a, right);
    }

    public static <A> Tree<A> leaf(A a) {
        return new Node<>(empty(), a, empty());
    }

    public static <A> Tree<A> empty() {
        return new Empty();
    }

}
