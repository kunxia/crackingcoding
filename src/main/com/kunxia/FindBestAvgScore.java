package com.kunxia;

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
public class FindBestAvgScore {
    public static void main(String[] args){
        JUnitCore.main("com.kunxia.FindBestAvgScore");
    }

    public String findBestAvgScore(String[][] grades) throws Exception{
        int bestAvgScore=Integer.MIN_VALUE;
        String bestAvgScorer=null;
        if(grades == null || grades.length==0){
            throw new Exception("Invalid Input");
        }
        else{
                Map<String, Integer> map= new HashMap<>();
                for(String[]entry: grades){
                    Integer score=map.get(entry[0]);
                    if(score !=null ){
                        Integer avg= (score+Integer.parseInt(entry[1]))/2;
                        map.put(entry[0],avg);
                    }else{
                        map.put(entry[0],Integer.parseInt(entry[1]));
                    }
                }
                for(Map.Entry<String, Integer> entry: map.entrySet()){
                 if(entry.getValue()>=bestAvgScore){
                     bestAvgScore=entry.getValue();
                     bestAvgScorer=entry.getKey();
                 }
                }
            }
            return bestAvgScorer;
        }

        FindBestAvgScore s;
        @Before
        public void init(){
            s=new FindBestAvgScore();
        }

        @Test (expected = Exception.class)
        public void throwsExceptionWhenInvalidInput() throws Exception{
            s.findBestAvgScore(null);
        }

        @Test (expected = Exception.class)
        public void throwsExceptionWhenEmpty() throws Exception{
            String[][] marks = {};
            s.findBestAvgScore(marks);
        }

        @Test
        public void oneSubjectPerPerson() throws Exception{
            String[][] marks = {{"bob","85"},{"lily","66"}};
            Assert.assertEquals("bob",s.findBestAvgScore(marks));
        }

        @Test
        public void multiSubjectsPerPerson() throws Exception{
            String[][] marks = {{"bob","85"},{"lily","84"},{"lily","100"}};
            Assert.assertEquals("lily",s.findBestAvgScore(marks));
        }

        @Test
        public void onePersonOneSubject() throws Exception{
            String[][] marks = {{"bob","85"}};
            Assert.assertEquals("bob",s.findBestAvgScore(marks));
        }

        @Test
        public void onePersonMultiSubjects() throws Exception{
            String[][] marks = {{"bob","85"},{"bob","23"}};
            Assert.assertEquals("bob",s.findBestAvgScore(marks));
        }

        @Test
        public void multiPersons() throws Exception{
            String[][] marks = {{"bob","85"},{"lily","50"},{"tom","60"},{"isaac","88"},{"tom","100"}};
            Assert.assertEquals("isaac",s.findBestAvgScore(marks));
        }
    }

