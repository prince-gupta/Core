package com.company.test;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class AbsoluteSort {
    public static void main(String[] args) {
        int[] array = {-34,-23,-21,-12,1,2,3,4,5,6,7};
        for(int i=0 ; i < array.length;i++){
            for(int j = i ; j < array.length;j++){
                if(Math.abs(array[i]) > Math.abs(array[j])){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int element : array){
            System.out.print(element + " ");
        }
    }
}
