package test.com.kunxia;

import main.com.kunxia.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    MyHashMap<Integer, String> map;
    @Before
    public void setUp(){
        map = new MyHashMap<Integer, String>();
    }
    @Test
    public void testPutAndGet(){
        map.put(1,"Kun Xia");
        map.put(2, "Ring Lu");
        assertNotNull(map);
        assertEquals("Kun Xia",map.get(1));
        assertEquals("Ring Lu",map.get(2));
        map.put(1,"Ring Lu");
        assertEquals("Ring Lu",map.get(1));
        map.put(3,"Mirah Su");
        assertEquals("Mirah Su",map.get(3));
        assertEquals(null,map.get(30));



    }
}