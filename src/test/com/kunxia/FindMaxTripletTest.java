package com.kunxia;

import com.kunxia.others.FindMaxTriplet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxTripletTest {
    FindMaxTriplet findMaxTriplet;
    @Before
    public void setUp() throws Exception {
        findMaxTriplet = new FindMaxTriplet();
    }

    @Test
    public void sampleTest(){
        int arr[] = {-10, -3, 5, 6, -20};
        int n = arr.length;
        int max = findMaxTriplet.maxProduct(arr, n);
        assertEquals(1200, max);
    }

    @Test
    public void sampleTest2(){
        int arr[] = { 1, 4, 3, -6, -7, 0 };
        int n = arr.length;
        int max = findMaxTriplet.maxProduct(arr, n);
        assertEquals(168, max);
    }
}