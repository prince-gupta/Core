package com.company.ds.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pgupta on 4/8/2015.
 */
public class Stack<T> {
    private List<T> stack;
    private int size;
    private boolean infiniteStack = true;

    public Stack(int size) {
        this.size = size;
        stack = new ArrayList<T>();
        infiniteStack = false;
    }

    public Stack() {
        stack = new ArrayList<T>();
    }

    public T pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("Stack is underflow !!");
        }
        T element = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return element;
    }

    public void push(T element) throws Exception {
        if (!infiniteStack && stack.size() == size) {
            throw new Exception("Stack is full !!");
        }
        stack.add(element);
    }

    public T peek() throws Exception {
        if(stack.size()==0)
            throw new Exception("Stack is underflow !!");
        return stack.get(stack.size()-1);
    }

    public int size() {
        return stack.size();
    }

    public void print() throws Exception {
        for (int index = stack.size() - 1; index >= 0; index--)
            System.out.println(stack.get(index));
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
