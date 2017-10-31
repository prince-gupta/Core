package com.company.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pgupta on 04-07-2016.
 */
public class TestCollection {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("efe");
        System.out.println(list
        .toString());
        int[] A = {1,4,-1,3,2};
        System.out.println(new TestCollection().solution(A));

    }

    public int solution(int[] A) {

        int counter = 0;
        return recurse(A, 0, counter);
    }

    public int recurse(int[] A, int index, int counter){
        if(A[index] != -1){
            ++counter;
            recurse(A, A[index], counter);
        }
        else{
            return counter
                    ;
        }
        return 0;
    }
}
