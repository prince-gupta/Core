package com.company.problems.programming.array;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class RotateArrayReversal {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7};
        rotate(arr,5);
        for(int element : arr)
            System.out.print(element+",");

    }

    public static void rotate(int[] arr, int order){

        if(arr == null || order < 0)
            throw new IllegalArgumentException("Illegal Arguments !!!");
        order = order % arr.length;

        int a = arr.length - order;
        reverse(arr,0, a-1);
        reverse(arr,a,arr.length-1);
        reverse(arr,0,arr.length-1);

    }

    public static void reverse(int arr[], int left, int right){
        if(arr.length == 1)
            return ;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right --;
            left ++;
        }
    }
}
