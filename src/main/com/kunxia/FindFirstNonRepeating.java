package com.kunxia;

import org.junit.*;
import org.junit.runner.*;
public class FindFirstNonRepeating {
    public static void main(String[] args){
        JUnitCore.main("com.kunxia.FindFirstNonRepeating");

    }

    public char findFirstNonRepeating(String s) throws Exception{
        if(s == null || "".equals(s)){
            throw new Exception("Invalid INput");
        }
        char[] count = new char[256];
        for(int i=0; i<s.length();i++){
            count[s.charAt(i)]++;
        }

        for(int i=0; i<s.length() ; i++){
            if(count[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return Character.MIN_VALUE;
    }
    FindFirstNonRepeating s;
    @Before
    public void init(){
        s = new FindFirstNonRepeating();
    }

    @Test(expected = Exception.class)
    public void emptyString() throws Exception{
        s.findFirstNonRepeating("");
    }

    @Test
    public void multiChars() throws Exception{
        Assert.assertEquals('e',s.findFirstNonRepeating("testa"));
    }

    @Test
    public void AllRepeating() throws Exception{
        Assert.assertEquals(Character.MIN_VALUE,s.findFirstNonRepeating("tt"));
    }
}
