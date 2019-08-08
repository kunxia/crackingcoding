package com.kunxia;

import com.kunxia.others.SmallestSum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestSumTest {

    SmallestSum ss;
    @Before
    public void setUp(){
        ss = new SmallestSum();
    }

    @Test
    public void sampleTest(){
        int arr[] = {3, -4, 2, -3, -1, 7, -5};
        int n = arr.length;
        assertEquals(-6, ss.findMinSum(arr,n));
    }

}