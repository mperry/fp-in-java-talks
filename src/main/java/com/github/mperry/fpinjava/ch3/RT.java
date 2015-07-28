package com.github.mperry.fpinjava.ch3;

//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MarkPerry on 28/07/2015.
 */
public class RT {

    @Test
    public void test1() {
        List<Integer> list = new LinkedList<>(Arrays.asList(1));
        list.add(1);
        List<Integer> list2 = list;
        Assert.assertTrue(list.size() == 2);

    }

}
