package com.github.mperry.fpinjava.ch4;

/**
 * Created by MarkPerry on 1/08/2015.
 */
public class Demo {


    int func(int i) throws Exception {
        int x = raise();
        try {
            return x + 1;
        } catch (Exception e) {
            return 0;
        }
    }

    int raise() throws Exception {
        throw new Exception();
    }

}
