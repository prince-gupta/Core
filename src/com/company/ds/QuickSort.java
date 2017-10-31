package com.company.ds;

/**
 * Created by Pgupta on 11/26/2014.
 */
public class QuickSort {
    private int partition(int[] list, int low, int high){
            int i, j, pivot, temp;
            pivot = list[low];
            i = low;
            j = high;
            while(true)
            {
                while(list[i] < pivot && list[i] != pivot)
                i++;
                while(list[j] > pivot && list[j] != pivot)
                j--;
                if(i < j)
                {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
                else
                {
                    return j;
                }
            }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] list = {25,52,37,63,14,17,8,6};
        System.out.println(quickSort.partition(list,0,list.length-1));
    }
}
