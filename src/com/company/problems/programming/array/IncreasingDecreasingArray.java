package com.company.problems.programming.array;

/**
 * Created by Pgupta on 4/8/2015.
 */

/**
 * Class to find the point where array stops
 * increasing .
 */
public class IncreasingDecreasingArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 87, 90, 12, 11, 10, 9, 8};
        int arrIndex=0;

        for (int index = 0; index < array.length; index++) {
            if(array[index] > array[index+1]) {
                arrIndex = index;
                break;
            }
        }
        System.out.println(arrIndex);
    }
}
