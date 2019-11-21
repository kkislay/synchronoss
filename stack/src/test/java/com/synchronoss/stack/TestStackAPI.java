package com.synchronoss.stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStackAPI {
    private StackApi stack;
    StackApi stack_blank;
    private String[] VALUES = {"000", "231", "23", "23", "23","58", "69", "100"};

    @Before
    public void setup() {
        stack = new StackImplementation();
        stack_blank = new StackImplementation();
        stack.pushall(VALUES);
    }

    @Test
    public void countOccurenceTest() throws Exception {
        assertEquals(1, stack.count("58"));
        assertEquals(0, stack.count("2"));
        assertEquals(VALUES.length, stack.count(""));
        assertEquals( "100", stack.peek());
        assertEquals( "100", stack.pop());
        assertEquals(VALUES.length-1, stack.count(""));
        assertTrue(stack.hasValue("231"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeTest() throws Exception {
        assertEquals(0, stack.count("-58"));
        assertEquals(0, stack.count("abc"));
        assertEquals(0, stack.count("23.89"));


    }
    @Test(expected = IllegalArgumentException.class)
    public void hasValueNegativeTest() {
        assertTrue(stack.hasValue(""));
        assertTrue(stack.hasValue("-58"));
        assertTrue(stack.hasValue("abc"));
        assertTrue(stack.hasValue("23.89"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushNegativeTest()  {
        stack.push("");
        stack.push("-58");
        stack.push("abc");
        stack.push("23.89");
    }
    @Test(expected = IllegalArgumentException.class)
    public void peekNegativeTest() throws Exception {
        stack_blank.peek();

    }

    @After
    public void deleteVariables() {
        VALUES= new String[]{};
    }
}
