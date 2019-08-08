package com.kunxia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class ReverseString {
    public String reverseStringBySwap(String s){
        if(s != null){
            char[] chars= s.toCharArray();
            for(int i=0; i < chars.length/2; i++){
                char tmp = chars[chars.length-1-i];
                chars[chars.length-1-i]=chars[i];
                chars[i]=tmp;
            }
            return new String(chars);
        }
        return s;
    }

    public String reverseWords(String s) {
        if (s != null) {
            String reversed="";
            s = s.trim();
            String[] words = s.split(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                reversed +=words[i]+" ";
            }
            return reversed.trim();
        }
        return s;
    }

    public String reverseString(String s){
        String reversed = "";
        if(s !=null){
            char[] chars = s.toCharArray();
            for(int i=chars.length-1; i>=0; i--){
                reversed += chars[i];
            }
        }else{
            reversed = s;
        }
        return reversed;
    }

    public static void main(String[] args) {
        JUnitCore.main("com.kunxia.ReverseString");
    }

    ReverseString s;

    @Before
    public void init() {
        s = new ReverseString();
    }

    @Test
    public void nullWord() {
        Assert.assertEquals(null, s.reverseWords(null));
    }

    @Test
    public void oneWord() {
        Assert.assertEquals("word", s.reverseWords("word"));
    }

    @Test
    public void fewWords() {
        Assert.assertEquals("three two one", s.reverseWords("one two three"));

    }

    @Test
    public void wordsWithLeadingSpace() {
        Assert.assertEquals("three two one", s.reverseWords(" one two three"));
    }

    @Test
    public void wordsWithTrailingSpace() {
        Assert.assertEquals("three two one", s.reverseWords("one two three "));
    }

    @Test
    public void emptyString(){
        Assert.assertEquals("",s.reverseString(""));
    }

    @Test
    public void nonEmptyString(){
        Assert.assertEquals("cba",s.reverseString("abc"));
    }

    @Test
    public void nullString(){
        Assert.assertEquals(null,s.reverseString(null));
    }

    @Test
    public void nullStringBySwap(){
        Assert.assertEquals(null,s.reverseStringBySwap(null));
    }

    @Test
    public void emptyStringBySwap(){
        Assert.assertEquals("",s.reverseStringBySwap(""));
    }

    @Test
    public void stringWithFewCharsBySwap(){
        Assert.assertEquals("cba",s.reverseStringBySwap("abc"));
    }

    @Test
    public void stringWithTwoCharsBySwap(){
        Assert.assertEquals("ba",s.reverseStringBySwap("ab"));
    }


}

