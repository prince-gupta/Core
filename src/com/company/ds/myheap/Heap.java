package com.company.ds.myheap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<Anytype extends Comparable<Anytype>> {

    private ArrayList<Anytype> heapArray;

    public Heap() {
        heapArray = new ArrayList<Anytype>();
    }

    /**
     * Method will shift new child up to its right place by comparing it on each level with
     * its parent.
     *
     * 1. It will fetch newly added child.
     * 2. Gets its parent.
     * 3. If parent is smaller than child.
     * 4. Swap them.
     * 5. Keeps on doing this util we reach to root of heap.
     */
    private void shiftUp() {
        /**Newly added child which will be at last index.*/
        int childAdded = heapArray.size() - 1;
        /**Iterate until we reach the root node,
         * which will be the first element in tha array.*/
        while (childAdded > 0) {
            /**Find parent of newly added child.*/
            int parent = (childAdded - 1) / 2;
            /**Compare newly added child with its parent at
             *  each level until we find a parent which has value greater than this child.*/
            if( heapArray.get(childAdded).compareTo(heapArray.get(parent)) > 0){
                Anytype temp = heapArray.get(parent);
                /**Swap new child with parent as it has greater value than parent.*/
                heapArray.set(parent,heapArray.get(childAdded));
                heapArray.set(childAdded,temp);
                /**moving a level up in heap to continue compare*/
                childAdded = parent;
            }
            /**We will stop as soon as we find any parent having
             * greater value than child, which will be the right place of child , otherwise it will root node.*/
            else
                break;
        }
    }

    /**
     * Method will shift parent down to its right place by comparing it on each level with their
     * children .
     * 1. First it will calculate the indexes for its child using formula
     *      leftChildIndex = 2 * parentIndex + 1
     *      rightChildIndex = leftChildIndex + 1
     * 2. It will compare item on leftChildIndex with rightChildIndex
     * 3. Which ever will be greater will be swapped with parent.
     * 4. Continues performing above steps until reached to end of heap.
     */
    private void shifDown(){
        int parent = 0;
    /**
     * Formula to find childs of a node :
     * Left Child = 2k + 1
     * Right Child = 2k + 2 or Left Child + 1
     * where k = index of parent.*/
        int leftChild = 2 * parent + 1;
        /**Loop until we reach end of heap*/
        while ( leftChild < heapArray.size()){
            int rightChild = leftChild + 1;
            /**This will hold the index of child which will have grater value so that
             it can be replaced with parent*/
            int max = leftChild ;
            /**Ensuring whether we have any right child. If so then it will
             * be in range < heapArray size*/
            if( rightChild < heapArray.size() ){
                /**Comparing leftChildElement and rightChildElement to be swapped with parentElement*/
                if(heapArray.get(leftChild).compareTo(heapArray.get(rightChild)) < 0){
                    ++max;
                }
            }
            /** Comparing selected max child with parent. */
            if( heapArray.get(max).compareTo(heapArray.get(parent)) > 0){
                /**As selected max child is greater than parent child so we swapping them so that
                 * parent will always be greater than its child. As requirement of heap*/
                Anytype temp = heapArray.get(max);
                heapArray.set(max,heapArray.get(parent));
                heapArray.set(parent,temp);

                /** Navigating to next level to continue shifting */
                parent = max;
                /**LeftChild of new parent */
                leftChild = 2 * parent + 1;
            }
            /**If child is smaller with its parent , no need to move further.*/
            else
                break;
        }
    }

    /**
     * Method will perform deletion and replacing root node with
     * last node in heap. And perform shifDown.
     */
    public Anytype delete() throws NoSuchElementException{

        if(heapArray.size() == 0){
            throw new NoSuchElementException();
        }

        /**If heap array has only one node, just return it*/
        if( heapArray.size() == 1){
            return heapArray.remove(0);
        }

        /** As deletion from heap will always return root node ,
         * which will be at 0th index in array*/
        Anytype hold = heapArray.get(0);

        /** After getting root node we will set root node with very last node in heap ,
         * so that shiftDown can be perform to rearrange the heap to satisfy all the constraints*/
        heapArray.set(0, heapArray.remove(heapArray.size()-1));
        /**Perform shiftDown*/
        shifDown();
        return hold;
    }

    /**
     * Method will simply add a new node to heap .
     * 1. Adds a new node to very last place in heap.
     * 2. Calls shiftUp to rearrange the heap to adjust new added node to its right place
     * @param item - Newly added node.
     */
    public void insert(Anytype item) {
        heapArray.add(item);
        shiftUp();
    }

    public boolean isEmpty(){
        return heapArray.isEmpty();
    }
    public String toString(){
        return heapArray.toString();
    }

    public static void main(String[] args){
        Heap<String> heap = new Heap<String>();
       // String[] array = {23,3,45,7,4,87,32,553,23,-2,-34,-53,12,34};
        String sentence = "the quick lazy fox jumps over a lazy dog";
        String[] array = sentence.split(" ");
        for(int i = 0 ; i < array.length; i++){
            heap.insert(array[i]);
        }
        while(!heap.isEmpty()){
            System.out.print(heap.delete() + ", ");
        }

    }
}
