package com.kunxia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeakAndTrough {
    public static void printPeaksAndTroughs(int[] arr){
        int start=1, end=arr.length-2;
        List<Integer> peaks = new ArrayList<>();
        List<Integer> troughs = new ArrayList<>();
        for(int i=start; i<=end; i++){
            int current = arr[i];
            int previous = arr[i-1];
            int next=arr[i+1];
            if(current>previous && current>next){
                peaks.add(current);
            }else if(i==end && current<next){
                peaks.add(next);
            }
            if(current<previous && current < next){
                troughs.add(current);
            }else if (i==start && previous<current){
                troughs.add(previous);
            }
        }
        System.out.println("Peaks:"+ Arrays.toString(peaks.toArray()));

        System.out.println("Troughs:"+ Arrays.toString(troughs.toArray()));
    }

    public static void main(String[] args){
        int[] arr = {5, 10, 5, 7, 4, 3, 5};
        PeakAndTrough.printPeaksAndTroughs(arr);
    }
}
