package com.synchronoss.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStackAPI {
    private StackApi stack;
    private StackApi stack_blank;
    private String[] VALUES = {"000", "231", "23", "23", "23","58", "69", "100", "1000", "200", "1232", "429", "343125426", "231"};

    @Before
    public void setup() {
        stack = new StackImplementation();
        stack_blank = new StackImplementation();
        stack.pushall(VALUES);
    }

    /* positive tests about the values inside the stack. */
    @Test
    public void countOccurenceTest() throws Exception {
        assertEquals(1, stack.count("58"));
        assertEquals(VALUES.length, stack.count(""));
        assertEquals( "231", stack.peek());
        assertEquals( "231", stack.pop());
        assertEquals(VALUES.length-1, stack.count(""));
        assertTrue(stack.hasValue("231"));
    }

    /* negative test if the value doesn't exit. Returns 0 */
    @Test
    public void valueDoesNotExistTest()  {
        assertEquals(0,stack.count("1111111111"));

    }

    /* negative tests with illegal arguments for count method. */
    @Test(expected = IllegalArgumentException.class)
    public void negativeTest() throws Exception {
        assertEquals(0, stack.count("-58"));
        assertEquals(0, stack.count("abc"));
        assertEquals(0, stack.count("23.89"));
    }

    /* negative tests for hasValue method. */
    @Test(expected = IllegalArgumentException.class)
    public void hasValueNegativeTest() {
        assertTrue(stack.hasValue("-58"));
        assertTrue(stack.hasValue("abc"));
        assertTrue(stack.hasValue("23.89"));
    }

    /* negative tests for push method */
    @Test(expected = IllegalArgumentException.class)
    public void pushNegativeTest()  {
        stack.push("");
        stack.push("-58");
        stack.push("abc");
        stack.push("23.89");
    }

    /* negative test for peek method*/
    @Test(expected = Exception.class)
    public void peekNegativeTest() throws Exception {
        stack_blank.peek();

    }

    /* Deleting all the values in tear down method */
    @After
    public void deleteVariables() {
        VALUES= new String[]{};
        stack = null;
        stack_blank = null;
    }
}
