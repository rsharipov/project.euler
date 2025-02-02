package com.rsharipov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SuffixArrayTest {

    @Test
    public void testSuffixArray() {
        test("abc");
        testForEveryPrefix("abcdeabbcd");
        testForEveryPrefix("aaaaaaaaaa");
        testForEveryPrefix("a");
        testForEveryPrefix("abcdfghijklmnopqrstuvwxyz");
        testForEveryPrefix("abcabcabcabcabcabc");
    }

    public void testForEveryPrefix(String input) {
        for (int i = 1; i <= input.length(); ++i) {
            test(input.substring(0, i));
        }
    }
    
    public void test(String input) {
        SuffixArray array = new SuffixArray(input, 'a', 'z');
        ArrayList<String> actual = new ArrayList<>();
        for (int i = 0; i < array.length(); ++i) {
            actual.add(input.substring(array.suffix(i)));
        }
        assertEquals(expected(input), actual);
    }
    
    public List<String> expected(String input) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            result.add(input.substring(i));
        }
        Collections.sort(result);
        return result;
    }
    
}
