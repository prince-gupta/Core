package com.company.ds.simpleheap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> items;

    public Heap() {
        items = new ArrayList<T>();
    }

    private void siftUp() {
        int child = items.size() - 1;
        while (child > 0) {
            int parentIndex = (child - 1) / 2;
            T item = items.get(child);
            T parent = items.get(parentIndex);
            if (item.compareTo(parent) > 0) {
                // swap
                items.set(child, parent);
                items.set(parentIndex, item);

                // move up one level
                child = parentIndex;
            } else {
                break;
            }
        }
    }

    public void insert(T item) {
        items.add(item);
        siftUp();
    }

    private void siftDown() {
        int parent = 0;
        int leftChild = 2 * parent + 1;
        while (leftChild < items.size()) {
            int max = leftChild, rightChild = leftChild + 1;
            if (rightChild < items.size()) { /**Just to make sure if right child is there or not.*/
                if (items.get(rightChild).compareTo(items.get(leftChild)) > 0) {
                    max++;
                }
            }
            if (items.get(parent).compareTo(items.get(max)) < 0) {
                // switch
                T temp = items.get(parent);
                items.set(parent, items.get(max));
                items.set(max, temp);
                parent = max;
                leftChild = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public T delete()
            throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        siftDown();
        return hold;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();

    }

    public String toString() {
        return items.toString();
    }
}