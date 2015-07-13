package com.github.mperry.fpinjava.ch2;

import static java.lang.System.out;

/**
 * Created by MarkPerry on 13/07/2015.
 */
public class GettingStarted {

    public static void main(String [] args) {
        out.println(formatAbs(-42));
    }

    static int abs(int n) {
        return n < 0 ? -n : n;
    }

    static String formatAbs(int x) {
        return String.format("The absolute value of %d is %d", x, abs(x));
    }

}
