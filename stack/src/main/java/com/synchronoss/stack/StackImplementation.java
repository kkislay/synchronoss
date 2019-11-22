package com.synchronoss.stack;

import java.util.ArrayList;
import java.util.List;

public class StackImplementation implements StackApi {
    private List<String> stackList = new ArrayList<String>();

    @Override
    public boolean hasValue(String value) throws IllegalArgumentException {
        if (value == null)
            throw new IllegalArgumentException("Value cannot be null");
        if (!value.matches("[0-9]*"))
            throw new IllegalArgumentException("Invalid value - value must be a string of numbers");
        return stackList.contains(value);
    }

    @Override
    public void push(String value) throws IllegalArgumentException {
        if (value == null)
            throw new IllegalArgumentException("Value cannot be null");
        if (!value.matches("[0-9]*"))
            throw new IllegalArgumentException("Invalid value - value must be a string of numbers");
        stackList.add(value);
    }

    @Override
    public String pop() throws Exception {
        if (stackList.size() == 0) {
            throw new Exception("The stack is empty");
        }
        String lastElement = stackList.get(stackList.size() - 1);
        stackList.remove(lastElement);
        return lastElement;
    }

    @Override
    public String peek() throws Exception {
        if (stackList.size() == 0) {
            throw new Exception("The stack is empty");
        }
        return stackList.get(stackList.size() - 1);
    }

    @Override
    public int count  (String pattern) throws IllegalArgumentException{
        /* This is to check if the pattern to be searched is numeric or not. If not then it throws exception after matching the regex */
        if (!pattern.matches("[0-9]*"))
            throw new IllegalArgumentException("Invalid value - value must be a string of numbers");
        /* integer variable to store the counts when a match is found */
        int counter = 0 ;
        /* If the pattern is empty then size of stack is returned. */
        if (pattern.equals(""))
            counter=stackList.size();
        int i=0;
        int stack_size = stackList.size();
        /* loop goes until stack has an element */
        while (stack_size>0)
        {
            if (pattern.equals(stackList.get(i)))
            {
                counter ++;
            }

            /* stackList.remove(search); This can also be used but it will start deleting elements from the stack */
            i++;
            stack_size--;
        }
        return counter;
    }

    // method to push all the elements from the string array.
    @Override
    public void pushall(String [] VALUES)
    {
        for (String val:VALUES)
            this.push(val);
    }
}
