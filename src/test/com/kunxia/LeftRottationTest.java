package com.kunxia;

import com.kunxia.others.LeftRottation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeftRottationTest {
    LeftRottation lr;
    @Before
    public void setUp() throws Exception {
        lr=new LeftRottation();
    }

    @Test
    public void testWithZeroRotation(){
        int n=0;
        int[] a={1,2,3,4,5};
        int[] expected={1,2,3,4,5};
        assertArrayEquals(expected, lr.rotLeft(a,n));
    }

    @Test
    public void testWithOneRotation(){
        int n=1;
        int[] a={1,2,3,4,5};
        int[] expected={2,3,4,5,1};
        assertArrayEquals(expected, lr.rotLeft(a,n));
    }

    @Test
    public void testWithSampleInput(){
        int n=4;
        int[] a={1,2,3,4,5};
        int[] expected={5,1,2,3,4};
        assertArrayEquals(expected, lr.rotLeft(a,n));
    }

    @Test
    public void testWithZeroRotationrotLeftImproved(){
        int n=0;
        int[] a={1,2,3,4,5};
        int[] expected={1,2,3,4,5};
        assertArrayEquals(expected, lr.rotLeftImproved(a,n));
    }

    @Test
    public void testWithOneRotationrotLeftImproved(){
        int n=1;
        int[] a={1,2,3,4,5};
        int[] expected={2,3,4,5,1};
        assertArrayEquals(expected, lr.rotLeftImproved(a,n));
    }

    @Test
    public void testWithSampleInputrotLeftImproved(){
        int n=4;
        int[] a={1,2,3,4,5};
        int[] expected={5,1,2,3,4};
        assertArrayEquals(expected, lr.rotLeftImproved(a,n));
    }
}