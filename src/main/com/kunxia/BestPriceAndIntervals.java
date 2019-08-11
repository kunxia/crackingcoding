package com.kunxia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class BestPriceAndIntervals {
    public static void main(String[] args) {
        JUnitCore.main("com.kunxia.BestPriceAndIntervals");
    }

    BestPriceAndIntervals s;

    @Before
    public void init() {
        s = new BestPriceAndIntervals();
    }

    @Test
    public void noOverLap() {
        List<Interval> input = new ArrayList<>();
        Interval i1 = new Interval(1, 5, 15);
        Interval i2 = new Interval(3, 7, 20);
        Interval i3 = new Interval(5, 10, 10);
        input.add(i1);
        input.add(i2);
        input.add(i3);

        List<Interval> output = new ArrayList<>();
        Interval o1 = new Interval(1, 5, 15);
        Interval o2 = new Interval(3, 7, 20);
        Interval o3 = new Interval(5, 10, 10);
        output.add(o1);
        output.add(o2);
        output.add(o3);
        //Assert.assertEquals(output, s.solve(input));
        Assert.assertArrayEquals(output.toArray(), s.solve(input).toArray());
    }

    class Interval {
        int price, startTime, endTime;

        public Interval(int price, int startTime, int endTime) {
            this.price = price;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, startTime, endTime);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return price == interval.price &&
                    startTime == interval.startTime &&
                    endTime == interval.endTime;
        }
    }

    public List<Interval> solve(List<Interval> arr) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        
        return arr;
    }
}
