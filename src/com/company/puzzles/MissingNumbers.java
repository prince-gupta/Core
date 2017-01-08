package com.company.puzzles;

/**
 * Created by Pgupta on 07-09-2016.
 */
public class MissingNumbers {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 7};
        boolean[] tempArr = new boolean[arr.length+2];
        for (int index = 0; index < arr.length; index++) {
            tempArr[arr[index]-1] = true;
        }

        for(int index = 0 ; index < tempArr.length ; index++){
            if(tempArr[index] == false)
                System.out.println(index+1);
        }

    }
}
