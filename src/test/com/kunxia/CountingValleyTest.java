package test.com.kunxia;

import main.com.kunxia.CountingValley;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountingValleyTest {

    CountingValley cv;
    @Before
    public void setUp() throws Exception {
        cv = new CountingValley();
    }

    @Test
    public void testWithOneStep(){
        int n = 1;
        String s="U";
        assertEquals(0, cv.countingValleys(n,s));
    }

    @Test
    public void testWithTwoVallies(){
        int n = 12;
        String s = "UUDDDDUUDDUU";
        assertEquals(2, cv.countingValleys(n,s));
    }

    @Test
    public void testWithOneVallies(){
        int n = 10;
        String s = "DDUDDUUDUU";
        assertEquals(1, cv.countingValleys(n,s));
    }

    @Test
    public void testWithSampleInput(){
        int n = 8;
        String s = "UDDDUDUU";
        assertEquals(1, cv.countingValleys(n,s));
    }
}