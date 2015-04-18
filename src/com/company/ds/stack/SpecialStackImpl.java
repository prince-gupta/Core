package com.company.ds.stack;

import java.lang.Integer;
/**
 * Created by Pgupta on 4/8/2015.
 */
public class SpecialStackImpl{
    private Stack<Integer> stack ;
    private  Stack<Integer> auxillaryStack ;
    private int size;

    SpecialStackImpl(int size){
        stack = new Stack<Integer>(size);
        auxillaryStack = new Stack<Integer>(size);
        this.size = size;
    }

    SpecialStackImpl(){
        stack = new Stack<Integer>();
        auxillaryStack = new Stack<Integer>();
    }

    public void push(Integer element) throws Exception {
        stack.push(element);
        if(auxillaryStack.size() == 0)
            auxillaryStack.push(element);
        else{
            if(element.compareTo(auxillaryStack.peek()) < 0){
                auxillaryStack.push(element);
            }
            else{
                auxillaryStack.push(auxillaryStack.peek());
            }
        }
    }

    public Integer pop() throws Exception {
        auxillaryStack.pop();
        return stack.pop();
    }

    public Integer getMin() throws Exception {
        return auxillaryStack.peek();
    }
    public static void main(String[] args) throws Exception {
        SpecialStackImpl specialStack = new SpecialStackImpl();
        specialStack.push(59);
        specialStack.push(595);
        specialStack.push(5);
        specialStack.push(19);
        specialStack.push(9);
        specialStack.push(56);
        System.out.println(specialStack.getMin());
    }
}
