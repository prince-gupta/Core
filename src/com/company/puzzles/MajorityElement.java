package com.company.puzzles;

/**
 * Created by Pgupta on 11/26/2015.
 */
public class MajorityElement {
    public static int findMajCandidate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        int count = 1, maj = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == maj) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj = arr[i];
                count = 1;
            }
        }
        return maj;
    }

    public static boolean verifyMajCandiate(int[] arr, int maj) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int n = arr.length, count = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] == maj){
                count ++;
            }
            if(count > n/2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3,3};
        int maj = findMajCandidate(arr);
        if(maj == Integer.MIN_VALUE || verifyMajCandiate(arr, maj) == false){
            System.out.println("No majority element");
        }
        else{
            System.out.println("Majority element :  " + maj);
        }
    }
}
