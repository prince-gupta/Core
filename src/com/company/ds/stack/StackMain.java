package com.company.ds.stack;

/**
 * Created by Pgupta on 4/8/2015.
 */
public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(5);
        try {
            stack.push(43);
            stack.push(56);
            stack.push(90);
            stack.push(1);
            stack.push(526);
            stack.print();
            stack.pop();
            stack.print();
            System.out.print(stack.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
