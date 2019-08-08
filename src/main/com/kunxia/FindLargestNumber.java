package com.kunxia;

import org.junit.*;
import org.junit.runner.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLargestNumber {

    public static void main(String[] args){
        JUnitCore.main("com.kunxia.FindLargestNumber") ;

    }

    public String findLargest(List<String> arr){
        String largest="";
        if(arr !=null) {
            Collections.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String X, String Y) {
                    // first append Y at the end of X
                    String XY = X + Y;
                    // then append X at the end of Y
                    String YX = Y + X;
                    // Now see which of the two formed numbers
                    // is greater
                    return XY.compareTo(YX) > 0 ? -1 : 1;
                }
            });
            for (String s : arr) {
                largest += s;
            }
        }
        return largest;
    }
    FindLargestNumber s;
    @Before
    public void init(){
        s=new FindLargestNumber();
    }

    @Test
    public void emptyInput(){
        Assert.assertEquals("", s.findLargest(null) );
    }

    @Test
    public void multiDifferentNumbers(){
        Assert.assertEquals("998764543431", s.findLargest(Arrays.asList(new String[]{"1", "34", "3", "98", "9", "76", "45", "4"})));
    }

    @Test
    public void twoSameNumbers(){
        Assert.assertEquals("9999", s.findLargest(Arrays.asList(new String[]{"99", "99"})));
    }

    @Test
    public void oneNumber(){
        Assert.assertEquals("99", s.findLargest(Arrays.asList(new String[]{"99"})));
    }
}
