package com.kunxia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {


    class MyHashmap<K, V> {

        private class Entry<K, V> {
            K key;
            V value;
            Entry<K, V> next;

            public Entry(K key, V value, Entry<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }

            @Override
            public int hashCode() {
                int hashValue = 5;
                hashValue = 17 * hashValue + ((key == null) ? 0 : key.hashCode());
                hashValue = 17 * hashValue + ((value == null) ? 0 : key.hashCode());
                return hashValue;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Entry) {
                    Entry e = (Entry) obj;
                    return (key.equals(e.key)) && (value.equals(e.value));
                }
                return false;
            }
        }

        private Entry<K, V>[] entries;
        private final int DEFAULT_CAPACITY = 16;
        private int size = 0;

        public MyHashmap() {
            this.entries = new Entry[DEFAULT_CAPACITY];
        }

        public MyHashmap(int size) {
            this.entries = new Entry[size];
        }

        public int size() {
            return size;
        }

        public void put(K key, V value) {
            Entry<K, V> entry = new Entry<K, V>(key, value, null);
            int index = computeHash(key) % entries.length;
            Entry<K, V> e = entries[index];
            if (e == null) {
                entries[index] = entry;
                ++size;
            } else {
                while (e.next != null) {
                    if (key.equals(e.key)) {
                        e.value = value;
                        return;
                    }
                    e = e.next;
                }
                if (key.equals(e.key)) {
                    e.value = value;
                } else {
                    e.next = entry;
                    ++size;
                }

            }

        }

        public V get(K key) {
            Entry<K, V> e = entries[computeHash(key) % entries.length];
            while (e != null) {
                if (key.equals(e.key)) {
                    return e.value;
                }
                e = e.next;
            }
            return null;
        }

        private int computeHash(K key) {
            if (key != null) {
                return Math.abs(key.hashCode());
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        JUnitCore.main("com.kunxia.Solution");
    }

    Solution s;

    @Before
    public void init() {
        s = new Solution();
    }

    @Test
    public void emptyMap() {
        MyHashmap<String, String> map = new MyHashmap<String, String>();
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void putDifferentEntriesWithDifferentValues() {
        MyHashmap<String, String> map = new MyHashmap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void putDifferentEntriesWithSameValue() {
        MyHashmap<String, String> map = new MyHashmap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v1");
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void updateTheSameEntry() {
        MyHashmap<String, String> map = new MyHashmap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k2", "v1");
        Assert.assertEquals(2, map.size());
        Assert.assertEquals("v1", map.get("k2"));
    }


}


/*
Your previous Plain Text content is preserved below:

This is a sandbox to experiment with CoderPad's execution capabilities.
It's a temporary, throw-away session only visible to you.

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!

 */