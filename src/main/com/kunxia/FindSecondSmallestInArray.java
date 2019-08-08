package com.kunxia;

import org.junit.*;
import org.junit.runner.*;
public class FindSecondSmallestInArray {
    public static void main(String[] args) {
        JUnitCore.main("com.kunxia.FindSecondSmallestInArray");
    }

    public int findSecondSmallest(int[] arr) throws Exception{
        if(arr == null || arr.length==0){
            throw new Exception("Invalid input"+arr);
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }else if(arr[i]<secondSmallest && arr[i]!=smallest){
                secondSmallest=arr[i];
            }
        }
        return secondSmallest;
    }

    public int findSecondSmallestBySwap(int[] arr) throws Exception{
        if(arr == null || arr.length==0){
            throw new Exception("Invalid input"+arr);
        }
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr[1];
    }

    FindSecondSmallestInArray s;

    @Before
    public void init(){
        s = new FindSecondSmallestInArray();
    }

    @Test(expected = Exception.class)
    public void canHandleInvalidInput() throws Exception{
       s.findSecondSmallest(null);
    }

    @Test (expected = Exception.class)
    public void canHandleEmptyInput() throws Exception{
        s.findSecondSmallest(null);
    }

    @Test
    public void arrayWithAllPositives() throws Exception{
        int[] arr = {2,1,3,6,9};
        Assert.assertEquals(2, s.findSecondSmallest(arr));
    }

    @Test
    public void arrayWithMixofPositiveAndNegative() throws Exception{
        int[] arr = {-2,-3,2,1,3,6,3};
        Assert.assertEquals(-2, s.findSecondSmallest(arr));
    }

    @Test
    public void arrayWithDuplicates() throws Exception{
        int[] arr = {-3,-3,2,1,3,6,3};
        Assert.assertEquals(-3, s.findSecondSmallest(arr));
    }

    @Test
    public void arrayWithAllPositivesBySwap() throws Exception{
        int[] arr = {2,1,3,6,9};
        Assert.assertEquals(2, s.findSecondSmallestBySwap(arr));
    }

    @Test
    public void arrayWithMixofPositiveAndNegativeBySwap() throws Exception{
        int[] arr = {-2,-3,2,1,3,6,3};
        Assert.assertEquals(-2, s.findSecondSmallestBySwap(arr));
    }

    @Test
    public void arrayWithDuplicatesBySwap() throws Exception{
        int[] arr = {5,4,3,2,1};
        Assert.assertEquals(2, s.findSecondSmallestBySwap(arr));
    }
}
