package com.kunxia;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LeftRottation {
    public int[] rotLeft(int[] a, int d) {
        if(d==0) return a;
        int count=1;
        //int[] result=null;
        while(count<=d){
            a=rotateOnce(a);
            ++count;
        }
        return a;
    }
    private int[] rotateOnce(int[] a){
        int[] result = new int[a.length];
        for(int i=1; i<a.length; i++){
            result[i-1]=a[i];
        }
        result[a.length-1]=a[0];
        return result;
    }

    public int[] rotLeftImproved(int[] a, int d) {
        if(d==0) return a;
        int[] b = new int[d];
        int[] c = new int[a.length-d];
        for(int i=0; i<d; i++){
            b[i]=a[i];
        }
        int count =0;
        for(int i=d; i<a.length; i++){
            c[count]=a[i];
            ++count;
        }
        IntStream joined = IntStream.concat(Arrays.stream(c), Arrays.stream(b));
        return joined.toArray();
    }

}
