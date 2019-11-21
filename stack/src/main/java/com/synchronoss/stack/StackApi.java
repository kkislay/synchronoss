package com.synchronoss.stack;


public interface StackApi {
    /**
     * Put a value on the top of the stack.
     * This method will throw an error unless the value is numeric string
     *
     * @return
     * @throws Exception
     * @Param value
     */
    void push(String value) throws IllegalArgumentException;

    /**
     * Looks at the number at the top of this stack without removing it from the stack.
     *
     * @return
     * @throws Exception
     */

    String peek() throws Exception;

    /**
     * Removes the number at the top of this stack and returns that number as a numeric string.
     * Will throw an exception if the stack is empty
     *
     * @return
     * @throws java.lang.Exception
     */

    String pop() throws Exception;

    /**
     * Checks if a number exists anywhere on the stack
     *
     * @return
     * @throws java.lang.Exception
     * @Param value
     */

    boolean hasValue(String value) throws IllegalArgumentException;

    /**
     * Gets a count of the number of items on the stack
     *
     * @return
     * @throws java.lang.Exception
     */

    int count(String pattern) throws IllegalArgumentException;

    void pushall(String [] VALUE);

}
