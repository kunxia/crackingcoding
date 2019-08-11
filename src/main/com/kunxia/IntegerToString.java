package com.kunxia;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {
    public static String intToString(Integer n){
      if(n ==0) {
          return "0";
      }
      boolean isNegative=n<0;
      boolean isMin = (n==Integer.MIN_VALUE);
      n=isNegative?(isMin?Integer.MAX_VALUE:-n):n;
      StringBuilder sb = new StringBuilder();
      List<Integer> digits=new ArrayList<>();
      while(n>0){
          int curr = n%10;
          n=n/10;
          digits.add(curr);
      }

      //special case for Integer.MIN_VALUE
        if(isMin){
            int digit = digits.get(0);
            digit+=1;
            digits.set(0,digit);
        }
      for(int i =digits.size()-1; i>=0; i--){
          sb.append(digits.get(i));
      }
      if(isNegative){
          return "-"+sb.substring(0);
      }else {
          return sb.substring(0);
      }
    }

    public static void main(String[] args){
        if("1234".equals(IntegerToString.intToString(1234))){
            System.out.println("test passed for input 1234");
        }else{
            System.out.println("test failed for input 1234");
        }

        if("-123".equals(IntegerToString.intToString(-123))){
            System.out.println("test passed for input -123");
        }else{
            System.out.println("test failed for input -123");
        }

        if("0".equals(IntegerToString.intToString(0))){
            System.out.println("test passed for input 0");
        }else{
            System.out.println("test failed for input 0");
        }

        if(Integer.toString(Integer.MIN_VALUE).equals(IntegerToString.intToString(Integer.MIN_VALUE))){
            System.out.println("test passed for input "+Integer.MIN_VALUE);
        }else{
            System.out.println("test failed for input "+Integer.MIN_VALUE);
        }

        if(Integer.toString(Integer.MAX_VALUE).equals(IntegerToString.intToString(Integer.MAX_VALUE))){
            System.out.println("test passed for input "+Integer.MAX_VALUE);
        }else{
            System.out.println("test failed for input "+Integer.MAX_VALUE);
        }
    }

}
