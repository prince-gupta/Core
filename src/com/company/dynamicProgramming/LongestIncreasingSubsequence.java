package com.company.dynamicProgramming;

import java.util.Scanner;

/**
 * Created by princegupta on 31/10/17.
 */
public class LongestIncreasingSubsequence {

    public int lis(int arr[]){
        if(arr.length == 1){
            return 1;
        }
        int temp_arr [] = new int[arr.length];
        int actualSoln[] = new int[arr.length];

        for(int index = 0 ; index < arr.length; index++){
            temp_arr[index] = 1;
            actualSoln[index] = index;
        }

        for(int i =0 ; i < arr.length; i++){
            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j]){
                    if(temp_arr[j] + 1 > temp_arr[i]){
                        temp_arr[i] = temp_arr[j] + 1;
                        actualSoln[i] = j;

                    }
                }
            }
        }
        int max = 0;
        for(int index = 0 ; index < temp_arr.length; index++){
            if(temp_arr[index] > temp_arr[max])
                max  =index;
        }

        //lets print the actual solution
        int t = max;
        int newT = max;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSoln[t];
        }while(t != newT);
        System.out.println();

        return temp_arr[max];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int arr [] = new int[len];
        for(int index = 0 ; index < len; index ++){
            arr[index] = scanner.nextInt();
        }
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.print(longestIncreasingSubsequence.lis(arr));
    }
}
